package interfaces;

import models.Patron;

public interface LibraryService {
    boolean checkoutBook(String isbn, Patron patron);
    boolean returnBook(String isbn, Patron patron);
}
