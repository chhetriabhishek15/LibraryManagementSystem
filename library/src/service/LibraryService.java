package service;

import interfaces.*;
import models.Book;
import models.BorrowerRecord;
import models.Patron;

import java.util.*;

public class LibraryService implements Library {
    private final ReservationObserver reservationService;
    private final Fine fineCalculator;
    private final Inventory inventory;
    private final Map<String,BorrowerRecord> borrowRecord;


    public LibraryService(ReservationObserver reservationService, Fine fineCalculator, Inventory inventory) {
        this.reservationService = reservationService;
        this.fineCalculator = fineCalculator;
        this.inventory = inventory;
        this.borrowRecord = new HashMap<>();
    }

    private void createBorrowingRecord(Patron patron,Book book){
        BorrowerRecord record = new BorrowerRecord(patron,book,new Date());
        borrowRecord.put(book.getISBN(), record);
        patron.addBorrowing(record);
    }

    private Optional<BorrowerRecord> processReturnedBook(String isbn, Patron patron){
        if (!borrowRecord.containsKey(isbn)){
            return Optional.empty();
        }
        BorrowerRecord record = borrowRecord.get(isbn);
        if (!record.getPatron().equals(patron)){
            return Optional.empty();
        }
        return Optional.of(record);
    }

    @Override
    public boolean checkoutBook(String isbn, Patron patron) {
        Optional<Book> aquiredBook = inventory.acquireBookForCheckout(isbn);
        aquiredBook.ifPresent(book -> createBorrowingRecord(patron,book));
        return aquiredBook.isPresent();
    }

    @Override
    public boolean returnBook(String isbn, Patron patron) {
        Optional<BorrowerRecord> processedBook = processReturnedBook(isbn,patron);
        processedBook.ifPresent(record -> {
                    record.setReturnDate(new Date());
                    inventory.processReturnedBook(record.getBook().getISBN());
                    borrowRecord.remove(record.getBook().getISBN());
                    double fine = fineCalculator.calculateFine(record);
                    if (fine > 0){
                        System.out.println("You have to pay fine"+fine);
                    }
                    else {
                        System.out.println("Thank you for returning the book");
                    }
                    reservationService.notifyAvailable(record.getBook());
        });
        return processedBook.isPresent();
    }

    @Override
    public void addReservation(String isbn, Patron patron) {
        Optional<Book> bookOptional = Optional.ofNullable(inventory.searchByIsbn(isbn));
        bookOptional.ifPresent(book -> reservationService.addReservation(book,patron));
    }
}
