package models;

import java.util.Date;

public class BorrowerRecord {
    private Book book;
    private Date checkoutDate;
    private Date returnDate;

    public BorrowerRecord(Book book, Date checkoutDate, Date returnDate) {
        this.book = book;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isActiveForBook(String bookISBN){
        return book.getISBN().equals(bookISBN) && returnDate == null;
    }

    public void markAsReturned(){
        this.returnDate= new Date();
    }
}
