package models;

import constants.BookStatus;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int publicationYear;
    private BookStatus bookStatus;

    public Book(String title, String author, String ISBN, int publicationYear, BookStatus bookStatus) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.bookStatus = BookStatus.AVAILABLE; //default;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public boolean isAvailable(){
        return bookStatus==BookStatus.AVAILABLE ;
    }
}
