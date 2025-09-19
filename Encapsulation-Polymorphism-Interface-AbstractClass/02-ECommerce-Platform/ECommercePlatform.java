import java.util.ArrayList;
import java.util.List;

public class ECommercePlatform {
    
    public static void calculateFinalPrice(List<Product> products) {
        System.out.println("=== E-Commerce Platform ===\n");
        for (Product product : products) {
            double discount = product.calculateDiscount();
            double tax = 0;
            
            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
                System.out.println(((Taxable) product).getTaxDetails());
            }
            
            double finalPrice = product.getPrice() + tax - discount;
            
            System.out.println("Product: " + product.getName());
            System.out.println("Original Price: " + product.getPrice());
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("------------------------");
        }
    }
    
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        
        Electronics laptop = new Electronics(1, "Gaming Laptop", 80000, "ASUS");
        Clothing shirt = new Clothing(2, "Cotton Shirt", 1200, "L");
        Groceries rice = new Groceries(3, "Basmati Rice", 500, "2024-12-31");
        
        products.add(laptop);
        products.add(shirt);
        products.add(rice);
        
        calculateFinalPrice(products);
    }
}
