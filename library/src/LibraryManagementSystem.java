import factory.LibraryFactory;
import interfaces.Inventory;
import interfaces.Library;
import models.Patron;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = LibraryFactory.createInventory();
        Library library = LibraryFactory.createLibrary(inventory);

        Patron alice = new Patron("P001", "Alice");
        Patron bob = new Patron("P002", "Bob");

        System.out.println("=== Borrowing Book ===");
        boolean borrowed = library.checkoutBook("Robert C. Martin", alice);
        System.out.println("Book borrowed: " + borrowed); // Expected: true

        System.out.println("\n=== Borrowing Already Borrowed Book ===");
        boolean borrowedAgain = library.checkoutBook("Robert C. Martin", bob);
        System.out.println("Book borrowed by Bob: " + borrowedAgain); // Expected: false

        System.out.println("\n=== Adding Reservation ===");
        library.addReservation("Robert C. Martin", bob);
        System.out.println("Bob has reserved the book.");

        System.out.println("\n=== Adding Reservation ===");
        library.addReservation("Robert C. Martin", alice);
        System.out.println("Alice has reserved the book.");

        System.out.println("\n=== Returning Book ===");
        boolean returned1 = library.returnBook("Robert C. Martin", alice);
        System.out.println("Book returned by Alice: " + returned1); // Expected: true

        System.out.println("\n=== Bob Borrows Reserved Book ===");
        boolean borrowedByBob = library.checkoutBook("Robert C. Martin", bob);
        System.out.println("Book borrowed by Bob: " + borrowedByBob); // Expected: true

        System.out.println("\n=== Returning Book ===");
        boolean returned2 = library.returnBook("Robert C. Martin", bob);
        System.out.println("Book returned by Alice: " + returned2); // Expected: true

    }
}

