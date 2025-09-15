package factory;

import constants.BookStatus;
import interfaces.FineService;
import interfaces.InventoryService;
import interfaces.LibraryService;
import models.Book;
import service.Fine;
import service.Inventory;
import service.Library;

import java.util.ArrayList;

public class LibraryFactory {
    public static InventoryService createInventory(){
        InventoryService inventoryService = new Inventory(new ArrayList<>());

        inventoryService.addBook(new Book("1111", "Clean Code", "Robert C. Martin", 2008, BookStatus.AVAILABLE));
        inventoryService.addBook(new Book("2222", "Effective Java", "Joshua Bloch", 2018, BookStatus.AVAILABLE));

        return inventoryService;
    }

    public static LibraryService createLibrary(InventoryService inventory){
        FineService fineService = new Fine();
        LibraryService libraryService = new Library(fineService,inventory);

        return libraryService;
    }
}
