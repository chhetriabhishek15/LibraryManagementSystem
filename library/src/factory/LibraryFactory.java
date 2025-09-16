package factory;

import constants.BookStatus;
import interfaces.*;
import models.Book;
import service.*;

import java.util.ArrayList;

public class LibraryFactory {
    public static Inventory createInventory(){
        Inventory inventoryService = new InventoryService(new ArrayList<>());

        inventoryService.addBook(new Book("1111", "Clean Code", "Robert C. Martin", 2008, BookStatus.AVAILABLE));
        inventoryService.addBook(new Book("2222", "Effective Java", "Joshua Bloch", 2018, BookStatus.AVAILABLE));

        return inventoryService;
    }

    public static Library createLibrary(Inventory inventory){
        Notification notificationService = new NotificationService();
        ReservationObserver reservationObserver = new ReservationService(notificationService);
        Fine fineService = new FineService();
        Library libraryService = new LibraryService(reservationObserver,fineService,inventory);

        return libraryService;
    }
}
