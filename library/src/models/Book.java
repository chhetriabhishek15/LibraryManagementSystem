package models;

import constants.BookStatus;

public class Book {
    private final String title;
    private final String author;
    private final String ISBN;
    private final int publicationYear;
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

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setBookStatus(BookStatus bookStatus){
        this.bookStatus=bookStatus;
    }

    public boolean isAvailable(){
        return bookStatus==BookStatus.AVAILABLE ;
    }
}
