package service;

import interfaces.Notification;
import interfaces.ReservationObserver;
import models.Book;
import models.Patron;
import models.Reservation;

import java.util.*;

public class ReservationService implements ReservationObserver {
    private final Map<String, List<Reservation>> reservationMap;
    private final Notification notificationService;

    public ReservationService(Notification notification) {
        this.reservationMap = new HashMap<>();
        this.notificationService = notification;
    }

    //Add a reservation
    public void addReservation(Book book, Patron patron){
        Reservation reservation = new Reservation(book,patron,new Date());
        reservationMap.computeIfAbsent(book.getISBN(), k-> new ArrayList<>()).add(reservation);
    }

    public List<Reservation> getReservationsForBook(Book book){
        return reservationMap.getOrDefault(book.getISBN(),new ArrayList<>());
    }

    @Override
    public void notifyAvailable(Book book) {
        Optional<List<Reservation>> optionalReservations = Optional.ofNullable(reservationMap.get(book.getISBN()));
        optionalReservations.ifPresent(reservations -> {
            if (!reservations.isEmpty()) {
                Reservation nextReservation = reservations.getFirst();
                notificationService.sendNotification(nextReservation.getPatron(),
                        "The book " + book.getTitle() + " is now available for checkout");
                reservations.removeFirst();
            }
        });
    }
}
