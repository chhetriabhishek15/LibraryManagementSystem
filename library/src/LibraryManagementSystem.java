import constants.BookStatus;
import factory.LibraryFactory;
import interfaces.FineService;
import interfaces.InventoryService;
import interfaces.LibraryService;
import models.Book;
import models.Patron;
import service.Fine;
import service.Inventory;
import service.Library;

import java.util.ArrayList;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        InventoryService inventory = LibraryFactory.createInventory();
        LibraryService library = LibraryFactory.createLibrary(inventory);

        Patron patron = new Patron("P001", "Alice");

        boolean borrowed = library.checkoutBook("Robert C. Martin", patron);
        System.out.println("Book borrowed: " + borrowed);

        // Return a book via library workflow
        boolean returned = library.returnBook("Robert C. Martin", patron);
        System.out.println("Book returned: " + returned);
    }
}
