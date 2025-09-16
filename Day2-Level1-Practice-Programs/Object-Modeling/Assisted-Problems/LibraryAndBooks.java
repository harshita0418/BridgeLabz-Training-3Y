import java.util.*;

class Book {
    private String title;
    private String author;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    private String libraryName;
    private ArrayList<Book> books;
    
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public void removeBook(Book book) {
        books.remove(book);
    }
    
    public void displayBooks() {
        System.out.println("Books in " + libraryName + ":");
        for (Book book : books) {
            book.displayBook();
        }
    }
}

public class LibraryAndBooks {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Doe");
        Book book2 = new Book("Data Structures", "Jane Smith");
        Book book3 = new Book("Algorithms", "Bob Johnson");
        
        Library centralLibrary = new Library("Central Library");
        Library branchLibrary = new Library("Branch Library");
        
        centralLibrary.addBook(book1);
        centralLibrary.addBook(book2);
        branchLibrary.addBook(book2);
        branchLibrary.addBook(book3);
        
        centralLibrary.displayBooks();
        System.out.println();
        branchLibrary.displayBooks();
        
        System.out.println("\nBooks exist independently:");
        book1.displayBook();
    }
}
