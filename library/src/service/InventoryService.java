package service;

import models.Book;

import java.util.List;

public interface InventoryService {
    void addBook(Book book);
    boolean removeBook(String isbn);
    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String author);
    Book searchByIsbn(String isbn);
}
