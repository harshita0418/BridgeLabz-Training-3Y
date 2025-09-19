public class Electronics extends Product implements Taxable {
    private String brand;
    
    public Electronics(int productId, String name, double price, String brand) {
        super(productId, name, price);
        this.brand = brand;
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1;
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * 0.18;
    }
    
    @Override
    public String getTaxDetails() {
        return "GST 18% applied for Electronics";
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
}
