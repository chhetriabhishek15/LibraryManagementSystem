package models;

import java.util.Date;

public class BorrowerRecord {
    private Patron patron;
    private Book book;
    private Date checkoutDate;
    private Date returnDate;

    public BorrowerRecord(Patron patron,Book book, Date checkoutDate) {
        this.patron = patron;
        this.book = book;
        this.checkoutDate = checkoutDate;
        this.returnDate = null;
    }

    public Patron getPatron(){
        return patron;
    }

    public Book getBook() {
        return book;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean hasBeenReturned(String bookISBN){
        return book.getISBN().equals(bookISBN) && returnDate == null;
    }

    public void markAsReturned(){
        this.returnDate = new Date();
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }
}
