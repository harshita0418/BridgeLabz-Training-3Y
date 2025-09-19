public class Book extends LibraryItem implements Reservable {
    private boolean isAvailable;
    private String reservedBy;
    
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }
    
    @Override
    public int getLoanDuration() {
        return 14;
    }
    
    @Override
    public boolean reserveItem(String borrowerName) {
        if (isAvailable) {
            isAvailable = false;
            reservedBy = borrowerName;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
    
    public String getReservedBy() {
        return reservedBy;
    }
}
