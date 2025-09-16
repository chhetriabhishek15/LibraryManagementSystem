import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import factory.LibraryFactory;
import interfaces.Inventory;
import interfaces.Library;
import models.Patron;

public class LibraryManagementSystem {
    private static final Logger logger = LoggerFactory.getLogger(LibraryManagementSystem.class);

    public static void main(String[] args) {
        logger.info("Starting LibraryManagementSystem");

        Inventory inventory = LibraryFactory.createInventory();
        Library library = LibraryFactory.createLibrary(inventory);

        Patron alice = new Patron("P001", "Alice");
        Patron bob = new Patron("P002", "Bob");

        logger.info("=== Borrowing Book ===");
        boolean borrowed = library.checkoutBook("Robert C. Martin", alice);
        logger.info("Book borrowed by Alice: {}", borrowed); // Expected: true

        logger.info("=== Borrowing Already Borrowed Book ===");
        boolean borrowedAgain = library.checkoutBook("Robert C. Martin", bob);
        logger.info("Book borrowed by Bob: {}", borrowedAgain); // Expected: false

        logger.info("=== Adding Reservation ===");
        library.addReservation("Robert C. Martin", bob);
        logger.info("Bob has reserved the book.");

        logger.info("=== Adding Reservation ===");
        library.addReservation("Robert C. Martin", alice);
        logger.info("Alice has reserved the book.");

        logger.info("=== Returning Book ===");
        boolean returned1 = library.returnBook("Robert C. Martin", alice);
        logger.info("Book returned by Alice: {}", returned1); // Expected: true

        logger.info("=== Bob Borrows Reserved Book ===");
        boolean borrowedByBob = library.checkoutBook("Robert C. Martin", bob);
        logger.info("Book borrowed by Bob: {}", borrowedByBob); // Expected: true

        logger.info("=== Returning Book ===");
        boolean returned2 = library.returnBook("Robert C. Martin", bob);
        logger.info("Book returned by Bob: {}", returned2); // Expected: true
    }
}