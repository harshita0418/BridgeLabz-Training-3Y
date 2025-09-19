public class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable;
    private String reservedBy;
    
    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }
    
    @Override
    public int getLoanDuration() {
        return 3;
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
