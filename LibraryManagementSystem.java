import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isAvailable;
    private User borrowedBy; // Track who borrowed the book

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.borrowedBy = null;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public User getBorrowedBy() {
        return borrowedBy;
    }

    // Set availability and borrower
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setBorrowedBy(User user) {
        borrowedBy = user;
    }

    public void displayBookDetails() {
        String borrowerInfo = isAvailable ? "Available" : "Borrowed by " + borrowedBy.getName();
        System.out.println("Title: " + title + ", Author: " + author + ", Status: " + borrowerInfo);
    }
}

class User {
    private String name;
    private String userId;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }
}

class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    // Register a user
    public void registerUser(String name, String userId) {
        users.add(new User(name, userId));
        System.out.println("User registered successfully!");
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the Library:");
            for (Book book : books) {
                book.displayBookDetails();
            }
        }
    }

    // Display all users
    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No registered users.");
        } else {
            System.out.println("Registered Users:");
            for (User user : users) {
                System.out.println("Name: " + user.getName() + ", User ID: " + user.getUserId());
            }
        }
    }

    // Search for a book by title
    public void searchBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.displayBookDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Borrow a book
    public void borrowBook(String title, String userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found. Please register first.");
            return;
        }

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    book.setBorrowedBy(user);
                    System.out.println(user.getName() + " has successfully borrowed \"" + title + "\".");
                } else {
                    System.out.println("Sorry, the book \"" + title + "\" is currently not available.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Return a book
    public void returnBook(String title, String userId) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable() && book.getBorrowedBy().getUserId().equals(userId)) {
                    book.setAvailable(true);
                    book.setBorrowedBy(null);
                    System.out.println("You have successfully returned \"" + title + "\".");
                } else {
                    System.out.println("You cannot return this book. Either it's not borrowed or not borrowed by you.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Find user by ID
    private User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Display Books");
            System.out.println("4. Display Users");
            System.out.println("5. Search for a Book");
            System.out.println("6. Borrow a Book");
            System.out.println("7. Return a Book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    String userId = scanner.nextLine();
                    library.registerUser(name, userId);
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    library.displayUsers();
                    break;
                case 5:
                    System.out.print("Enter the title of the book to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 6:
                    System.out.print("Enter your User ID: ");
                    String borrowerId = scanner.nextLine();
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle, borrowerId);
                    break;
                case 7:
                    System.out.print("Enter your User ID: ");
                    String returnUserId = scanner.nextLine();
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle, returnUserId);
                    break;
                case 8:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
