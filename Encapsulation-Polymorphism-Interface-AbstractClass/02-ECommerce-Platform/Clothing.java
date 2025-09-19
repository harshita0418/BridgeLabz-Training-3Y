public class Clothing extends Product implements Taxable {
    private String size;
    
    public Clothing(int productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }
    
    @Override
    public String getTaxDetails() {
        return "GST 5% applied for Clothing";
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
}
