import java.util.Scanner;


class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private int quantity;

    // Constructor
    public Book(String title, String author, String isbn, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // Update quantity
    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    // Calculate total value for this book
    public double totalValue() {
        return price * quantity;
    }

    // Display book info
    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("----------------------");
    }
}

// ---------------- Library Class ----------------
class Library {
    private String libraryName;
    private Book[] books;
    private int totalBooks;

    // Constructor
    public Library(String libraryName, int capacity) {
        this.libraryName = libraryName;
        this.books = new Book[capacity];
        this.totalBooks = 0;
    }

    // Add book to library
    public void addBook(Book book) {
        if (totalBooks < books.length) {
            books[totalBooks++] = book;
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Library is full! Cannot add more books.");
        }
    }

    // Search book by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                books[i].displayBook();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with title: " + title);
        }
    }

    // Search book by author
    public void searchByAuthor(String author) {
        boolean found = false;
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                books[i].displayBook();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found by author: " + author);
        }
    }

    // Display all books
    public void displayInventory() {
        if (totalBooks == 0) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Library Inventory of " + libraryName + ":");
        for (int i = 0; i < totalBooks; i++) {
            books[i].displayBook();
        }
    }

    // Calculate total value of all books
    public double calculateTotalValue() {
        double totalValue = 0;
        for (int i = 0; i < totalBooks; i++) {
            totalValue += books[i].totalValue();
        }
        return totalValue;
    }
}

// ---------------- Main System ----------------
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Library
        Library library = new Library("Central Library", 100);

        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Search Book by Author");
            System.out.println("4. Display All Books");
            System.out.println("5. Calculate Total Value");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    Book book = new Book(title, author, isbn, price, quantity);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle);
                    break;

                case 3:
                    System.out.print("Enter author to search: ");
                    String searchAuthor = scanner.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;

                case 4:
                    library.displayInventory();
                    break;

                case 5:
                    System.out.println("Total value of all books: $" + library.calculateTotalValue());
                    break;

                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        scanner.close();

        
    }
}
