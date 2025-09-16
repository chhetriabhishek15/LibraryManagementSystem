package interfaces;

import models.Patron;

public interface Library {
    boolean checkoutBook(String isbn, Patron patron);
    boolean returnBook(String isbn, Patron patron);
    void addReservation(String isbn, Patron patron);
}
