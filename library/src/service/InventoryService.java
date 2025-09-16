package service;

import constants.BookStatus;
import interfaces.Inventory;
import models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryService implements Inventory {
    private final List<Book> books;

    public InventoryService(List<Book> books) {
        this.books = new ArrayList<>(books);
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public boolean removeBook(String isbn) {
        return books.removeIf(book -> book.getISBN().equals(isbn));
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .toList();
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .toList();
    }

    @Override
    public Book searchByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getISBN().equalsIgnoreCase(isbn))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Optional<Book> acquireBookForCheckout(String isbn) {
        Book book = searchByIsbn(isbn);
        if (book == null || !book.isAvailable()){
            return  Optional.empty();
        }
        book.setBookStatus(BookStatus.BOOKED);
        return Optional.of(book);
    }

    @Override
    public void processReturnedBook(String isbn) {
        Book book = searchByIsbn(isbn);
        if (book != null){
            book.setBookStatus(BookStatus.AVAILABLE);
        }
        else {
            System.err.println("Attempted to process a return for a non-existent book with ISBN: " + isbn);
        }
        }
}

