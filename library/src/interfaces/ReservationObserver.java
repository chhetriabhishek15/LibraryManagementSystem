package interfaces;

import models.Book;
import models.Patron;
import models.Reservation;

import java.util.List;

public interface ReservationObserver {
    void addReservation(Book book, Patron patron);
    void notifyAvailable(Book book);
    List<Reservation> getReservationsForBook(Book book);
}
