package interfaces;

import models.Book;

import java.util.List;
import java.util.Optional;

public interface Inventory {
    void addBook(Book book);
    boolean removeBook(String isbn);
    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String author);
    Book searchByIsbn(String isbn);
    Optional<Book> acquireBookForCheckout(String isbn);
    void processReturnedBook(String isbn);
}
