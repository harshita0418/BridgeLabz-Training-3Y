import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        
        Book book = new Book(1, "Java Programming", "John Smith");
        Magazine magazine = new Magazine(2, "Tech Today", "Editor Team");
        DVD dvd = new DVD(3, "Learning Java", "Oracle Corp");
        
        items.add(book);
        items.add(magazine);
        items.add(dvd);
        
        System.out.println("=== Library Management System ===\n");
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            
            if (item instanceof Reservable) {
                boolean available = ((Reservable) item).checkAvailability();
                System.out.println("Available: " + available);
                
                if (available) {
                    boolean reserved = ((Reservable) item).reserveItem("Alice Johnson");
                    System.out.println("Reserved: " + reserved);
                }
            }
            System.out.println("------------------------");
        }
    }
}
