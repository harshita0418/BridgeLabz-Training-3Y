public class VegItem extends FoodItem implements Discountable {
    
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
    
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }
    
    @Override
    public String getDiscountDetails() {
        return "5% discount applied on Veg items";
    }
}
