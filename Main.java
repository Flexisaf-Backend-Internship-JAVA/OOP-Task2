import java.util.ArrayList;
import java.util.List;

// Book class
class Book {
    private String title;
    private String author;
    private String isbn;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book [Title: " + title + ", Author: " + author + ", ISBN: " + isbn + "]";
    }
}

// Library class to manage a collection of books
class Library {
    private List<Book> books = new ArrayList<>();

    // Add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added: " + book);
    }

    // Remove a book by ISBN
    public void removeBook(String isbn) {
        Book toRemove = null;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                toRemove = book;
                break;
            }
        }
        if (toRemove != null) {
            books.remove(toRemove);
            System.out.println("Removed: " + toRemove);
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Library Collection:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Create books
        Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "12345");
        Book b2 = new Book("1984", "George Orwell", "67890");
        Book b3 = new Book("To Kill a Mockingbird", "Harper Lee", "54321");
        
        // Add books
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        // Display books
        library.displayBooks();

        // Remove a book
        library.removeBook("67890");

        // Display after removal
        library.displayBooks();
    }
}