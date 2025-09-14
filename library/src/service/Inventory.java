package service;

import models.Book;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements InventoryService{
    private List<Book> books;

    public Inventory(List<Book> books) {
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
                .filter(book -> book.getISBN().equals(isbn))
                .findFirst()
                .orElse(null);
    }
}
