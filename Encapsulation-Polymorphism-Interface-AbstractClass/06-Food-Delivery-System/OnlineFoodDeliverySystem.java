import java.util.ArrayList;
import java.util.List;

public class OnlineFoodDeliverySystem {
    
    public static void processOrder(List<FoodItem> orderItems) {
        System.out.println("=== Online Food Delivery System ===\n");
        double grandTotal = 0;
        
        for (FoodItem item : orderItems) {
            System.out.println(item.getItemDetails());
            double totalPrice = item.calculateTotalPrice();
            double discount = 0;
            
            if (item instanceof Discountable) {
                discount = ((Discountable) item).applyDiscount();
                System.out.println(((Discountable) item).getDiscountDetails());
            }
            
            double finalPrice = totalPrice - discount;
            grandTotal += finalPrice;
            
            System.out.println("Total Price: " + totalPrice);
            System.out.println("Discount: " + discount);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("------------------------");
        }
        
        System.out.println("Grand Total: " + grandTotal);
    }
    
    public static void main(String[] args) {
        List<FoodItem> orderItems = new ArrayList<>();
        
        VegItem pizza = new VegItem("Margherita Pizza", 350, 2);
        NonVegItem chicken = new NonVegItem("Chicken Biryani", 280, 1);
        VegItem salad = new VegItem("Greek Salad", 180, 1);
        
        orderItems.add(pizza);
        orderItems.add(chicken);
        orderItems.add(salad);
        
        processOrder(orderItems);
    }
}
