import java.util.HashMap;
import java.util.Scanner;

public class pa2 {
    public static void main(String[] args) {
        // Initialize data structures for books and borrowed books
        HashMap<String, String[]> books = new HashMap<String, String[]>();
        HashMap<String, String[]> borrowed_books = new HashMap<String, String[]>();

        // Initialize scanner for user input
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Library System!");

        // Main loop for user interactions
        // Initialize variable for program runtime control
        boolean exit = false;
        while (!exit) {
            System.out.println("\nPlease choose an action:");
            System.out.println("1. Add a book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");

            // Read user's choice
            var command = scan.next().toLowerCase();

            // Process user's choice
            if (command.equals("4")) {
                exit = true;
                System.out.println("Thank you for using the Library System. Exiting...");
            } else {
                switch (command) {
                    case "1":
                        add_book(scan, books);
                        break;
                    case "2":
                        borrow_book(scan, books, borrowed_books);
                        break;

                    case "3":
                        return_book(scan, books, borrowed_books);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option (1-4).");
                        break;
                }
            }

        }
        // Close scanner to prevent resource leak
        scan.close();

    }

    // Method to add a book to the library
    static void add_book(Scanner scan, HashMap<String, String[]> books) {
        // Prompt user for book details
        System.out.println("\nEnter book details:");

        System.out.print("Title: ");
        String book_title = scan.next();

        System.out.print("Author: ");
        String book_author = scan.next();

        System.out.print("Quantity: ");
        String book_quantity = scan.next();

        // Add book to the library
        String book = book_title;
        String[] details = { book_author, book_quantity };
        books.put(book, details);

        // Display success message
        System.out.println("Book added successfully!");

    }

    // Method to borrow a book from the library
    static void borrow_book(Scanner scan, HashMap<String, String[]> books, HashMap<String, String[]> borrowed_books) {
        // Prompt user for book details
        System.out.println("\nEnter details to borrow a book:");

        System.out.print("Title: ");
        String book_title = scan.next();

        System.out.print("Author: ");
        String book_author = scan.next();

        System.out.print("Quantity: ");
        String book_quantity = scan.next();

        // Check if the book exists in the library
        if (books.containsKey(book_title)) {
            // Check if there are enough copies available
            if (Integer.parseInt(books.get(book_title)[1]) >= Integer.parseInt(book_quantity)) {
                int newQuantity = Integer.parseInt(books.get(book_title)[1]) - Integer.parseInt(book_quantity);
                // Update library inventory
                books.get(book_title)[1] = String.valueOf(newQuantity);

                // Display success message
                System.out.println("Book borrowed successfully!");

            } else {
                // Display error message
                System.out.println("Not enough copies available to cover your demand.");
            }

            String book = book_title;
            String[] details = { book_author, book_quantity };

            // Check if the book exists in the library
            if (books.containsKey(book_title)) {
                // Check if the borrowed inventory is empty
                if (borrowed_books.isEmpty()) {
                    // Add book to the borrowed inventory
                    borrowed_books.put(book, details);
                } else {
                    int newQuantity = Integer.parseInt(borrowed_books.get(book_title)[1])
                            + Integer.parseInt(book_quantity);
                    // Update book quantity in the borrowed inventory
                    borrowed_books.get(book_title)[1] = String.valueOf(newQuantity);
                }
            }
        } else {
            // Display error message
            System.out.println("Book not found in the library.");
        }

    }

    // Method to return a borrowed book to the library
    static void return_book(Scanner scan, HashMap<String, String[]> books, HashMap<String, String[]> borrowed_books) {
        // Prompt user for book details
        System.out.println("\nEnter details to return a book:");

        System.out.print("Title: ");
        String book_title = scan.next();

        System.out.print("Quantity: ");
        String book_quantity = scan.next();

        // Check if the book exists in the borrowed inventory
        if (borrowed_books.containsKey(book_title)) {
            // Check if amount to return isn't greater than what was borrowed
            if (Integer.parseInt(borrowed_books.get(book_title)[1]) >= Integer.parseInt(book_quantity)) {
                int newQuantity = Integer.parseInt(borrowed_books.get(book_title)[1]) - Integer.parseInt(book_quantity);
                // Update book quantity in the borrowed inventory and library inventory
                borrowed_books.get(book_title)[1] = String.valueOf(newQuantity);
                books.get(book_title)[1] = String
                        .valueOf(Integer.parseInt(books.get(book_title)[1]) + Integer.parseInt(book_quantity));
                // Display success message
                System.out.println("Book returned successfully!");

            } else {
                // Display error message
                System.out.println("You cannot return more books than you borrowed.");
            }

            // Check if the book exists in the library inventory
            if (books.containsKey(book_title)) {
                // If all borrowed books returned, clear the borrowed inventory
                if (Integer.parseInt(borrowed_books.get(book_title)[1]) == 0) {
                    borrowed_books.remove(book_title);
                }
            } else {
                // Display error message
                System.out.println("Book not found in the library inventory.");
            }
        } else {
            // Display error message
            System.out.println("Book not found in the borrowed inventory.");
        }
    }

}
