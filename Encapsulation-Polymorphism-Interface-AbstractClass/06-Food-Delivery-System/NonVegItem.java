public class NonVegItem extends FoodItem implements Discountable {
    private double additionalCharge;
    
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.additionalCharge = 20.0;
    }
    
    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + additionalCharge;
    }
    
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.02;
    }
    
    @Override
    public String getDiscountDetails() {
        return "2% discount applied on Non-Veg items (Additional charge: " + additionalCharge + ")";
    }
    
    public double getAdditionalCharge() {
        return additionalCharge;
    }
    
    public void setAdditionalCharge(double additionalCharge) {
        if (additionalCharge >= 0) {
            this.additionalCharge = additionalCharge;
        }
    }
}
