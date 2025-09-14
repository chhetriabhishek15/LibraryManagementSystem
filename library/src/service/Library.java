package service;

import constants.BookStatus;
import interfaces.InventoryService;
import interfaces.LibraryService;
import models.Book;
import models.BorrowerRecord;
import models.Patron;

import java.util.Date;

public class Library implements LibraryService {
    private final InventoryService inventory;

    public Library(InventoryService  inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean checkoutBook(String isbn, Patron patron) {
        Book book = inventory.searchByIsbn(isbn);
        if (book == null || !book.isAvailable()){
            return false;
        }
        book.setBookStatus(BookStatus.BOOKED);
        Date date = new Date();
        BorrowerRecord record = new BorrowerRecord(book,date);
        patron.addBorrowing(record);

        return true;
    }

    @Override
    public boolean returnBook(String isbn, Patron patron) {
        Book book = inventory.searchByIsbn(isbn);
        if (book==null){
            return false;
        }
        boolean success = patron.returnBook(isbn);
        if (success){
            book.setBookStatus(BookStatus.AVAILABLE);
        }

        return success;
    }
}
