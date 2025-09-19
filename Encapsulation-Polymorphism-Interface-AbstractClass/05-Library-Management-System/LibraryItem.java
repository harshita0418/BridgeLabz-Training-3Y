public abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;
    
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    
    public abstract int getLoanDuration();
    
    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }
    
    public int getItemId() {
        return itemId;
    }
    
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
}
