import constants.BookStatus;
import interfaces.InventoryService;
import interfaces.LibraryService;
import models.Book;
import models.Patron;
import service.Inventory;
import service.Library;

import java.util.ArrayList;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        InventoryService inventory = new Inventory(new java.util.ArrayList<>());

        inventory.addBook(new Book("1111", "Clean Code", "Robert C. Martin", 2008, BookStatus.AVAILABLE));
        inventory.addBook(new Book("2222", "Effective Java", "Joshua Bloch", 2018, BookStatus.AVAILABLE));

        LibraryService library = new Library(inventory);

        Patron patron = new Patron("P001", "Alice");

        boolean borrowed = library.checkoutBook("Robert C. Martin", patron);
        System.out.println("Book borrowed: " + borrowed);

        // Return a book via library workflow
        boolean returned = library.returnBook("Robert C. Martin", patron);
        System.out.println("Book returned: " + returned);
    }
}
