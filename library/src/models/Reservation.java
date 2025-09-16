package models;

import java.util.Date;

public class Reservation {
    private final Book book;
    private final Patron patron;
    private final Date reservationDate;

    public Reservation(Book book, Patron patron, Date reservationDate) {
        this.book = book;
        this.patron = patron;
        this.reservationDate = reservationDate;
    }

    public Book getBook() {
        return book;
    }

    public Patron getPatron() {
        return patron;
    }

    public Date getReservationDate() {
        return reservationDate;
    }
}
