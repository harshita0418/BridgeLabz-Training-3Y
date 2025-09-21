import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Product class representing items in the store
class Product {
    private String name;
    private double price;  // price per unit
    private double quantity;
    private String unit;   // kg, liter, piece, etc.
    
    public Product(String name, double price, double quantity, String unit) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getQuantity() {
        return quantity;
    }
    
    public String getUnit() {
        return unit;
    }
    
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    public double getTotalCost() {
        return price * quantity;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%.2f %s @ $%.2f per %s)", 
            name, quantity, unit, price, unit);
    }
}

// Customer class with composition relationship to Product
class Customer {
    private String name;
    private String customerId;
    private String email;
    private List<Product> cart;  // Composition - cart items belong to customer
    
    public Customer(String name, String customerId, String email) {
        this.name = name;
        this.customerId = customerId;
        this.email = email;
        this.cart = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public String getCustomerId() {
        return customerId;
    }
    
    public String getEmail() {
        return email;
    }
    
    public List<Product> getCart() {
        return cart;
    }
    
    public void addToCart(Product product) {
        // Check if product already exists in cart
        for (Product existingProduct : cart) {
            if (existingProduct.getName().equals(product.getName())) {
                existingProduct.setQuantity(existingProduct.getQuantity() + product.getQuantity());
                return;
            }
        }
        cart.add(product);
    }
    
    public void removeFromCart(String productName) {
        cart.removeIf(product -> product.getName().equals(productName));
    }
    
    public void clearCart() {
        cart.clear();
    }
    
    public double getCartTotal() {
        return cart.stream().mapToDouble(Product::getTotalCost).sum();
    }
    
    @Override
    public String toString() {
        return "Customer{name='" + name + "', id='" + customerId + "', items=" + cart.size() + "}";
    }
}

// BillGenerator class for computing and generating bills
class BillGenerator {
    private static final double TAX_RATE = 0.08; // 8% sales tax
    private static final double DISCOUNT_THRESHOLD = 100.0; // $100 for discount eligibility
    private static final double DISCOUNT_RATE = 0.05; // 5% discount
    
    public double calculateSubtotal(Customer customer) {
        return customer.getCartTotal();
    }
    
    public double calculateTax(double subtotal) {
        return subtotal * TAX_RATE;
    }
    
    public double applyDiscount(double subtotal) {
        if (subtotal >= DISCOUNT_THRESHOLD) {
            return subtotal * DISCOUNT_RATE;
        }
        return 0.0;
    }
    
    public double calculateTotal(Customer customer) {
        double subtotal = calculateSubtotal(customer);
        double tax = calculateTax(subtotal);
        double discount = applyDiscount(subtotal);
        return subtotal + tax - discount;
    }
    
    public void generateBill(Customer customer) {
        if (customer.getCart().isEmpty()) {
            System.out.println("Cart is empty. Nothing to bill.");
            return;
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           GROCERY STORE RECEIPT");
        System.out.println("=".repeat(50));
        System.out.println("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("Customer: " + customer.getName());
        System.out.println("ID: " + customer.getCustomerId());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("-".repeat(50));
        
        // Print each item
        System.out.printf("%-20s %-8s %-8s %-10s%n", "ITEM", "QTY", "UNIT", "TOTAL");
        System.out.println("-".repeat(50));
        
        for (Product product : customer.getCart()) {
            System.out.printf("%-20s %-8.2f %-8s $%-9.2f%n",
                product.getName(),
                product.getQuantity(),
                product.getUnit(),
                product.getTotalCost());
        }
        
        // Calculate totals
        double subtotal = calculateSubtotal(customer);
        double tax = calculateTax(subtotal);
        double discount = applyDiscount(subtotal);
        double total = subtotal + tax - discount;
        
        System.out.println("-".repeat(50));
        System.out.printf("%-38s $%-9.2f%n", "Subtotal:", subtotal);
        
        if (discount > 0) {
            System.out.printf("%-38s -$%-8.2f%n", "Discount (5%):", discount);
        }
        
        System.out.printf("%-38s $%-9.2f%n", "Tax (8%):", tax);
        System.out.println("-".repeat(50));
        System.out.printf("%-38s $%-9.2f%n", "TOTAL:", total);
        System.out.println("=".repeat(50));
        
        if (discount > 0) {
            System.out.println("🎉 You saved $" + String.format("%.2f", discount) + " with our discount!");
        }
        
        System.out.println("Thank you for shopping with us!");
        System.out.println("=".repeat(50));
    }
    
    public void printQuickSummary(Customer customer) {
        double total = calculateTotal(customer);
        System.out.printf("\n%s's cart: %d items, Total: $%.2f%n", 
            customer.getName(), customer.getCart().size(), total);
    }
}

// Main application class
public class GroceryStoreBillGeneration {
    public static void main(String[] args) {
        // Create customer instances
        Customer alice = new Customer("Alice Johnson", "C001", "alice.johnson@email.com");
        Customer bob = new Customer("Bob Smith", "C002", "bob.smith@email.com");
        
        // Create product instances and add to Alice's cart
        alice.addToCart(new Product("Apples", 3.0, 2.0, "kg"));
        alice.addToCart(new Product("Milk", 2.5, 2.0, "liter"));
        alice.addToCart(new Product("Bread", 2.0, 3.0, "loaf"));
        alice.addToCart(new Product("Eggs", 4.5, 1.0, "dozen"));
        alice.addToCart(new Product("Bananas", 1.5, 1.5, "kg"));
        
        // Add more apples to demonstrate quantity updating
        alice.addToCart(new Product("Apples", 3.0, 1.0, "kg"));
        
        // Create bill generator
        BillGenerator billGenerator = new BillGenerator();
        
        // Generate bill for Alice
        billGenerator.generateBill(alice);
        
        // Demonstrate Bob's shopping (smaller cart)
        bob.addToCart(new Product("Coffee", 12.0, 1.0, "bag"));
        bob.addToCart(new Product("Sugar", 3.5, 1.0, "kg"));
        
        billGenerator.generateBill(bob);
        
        // Demonstrate large order for discount
        Customer charlie = new Customer("Charlie Brown", "C003", "charlie@email.com");
        charlie.addToCart(new Product("Rice", 15.0, 5.0, "kg"));
        charlie.addToCart(new Product("Chicken", 8.0, 3.0, "kg"));
        charlie.addToCart(new Product("Vegetables", 4.0, 2.0, "kg"));
        charlie.addToCart(new Product("Juice", 5.5, 4.0, "liter"));
        charlie.addToCart(new Product("Cereals", 6.5, 2.0, "box"));
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           LARGE ORDER (DISCOUNT ELIGIBLE)");
        billGenerator.generateBill(charlie);
        
        // Quick summaries
        System.out.println("\n=== CUSTOMER SUMMARIES ===");
        billGenerator.printQuickSummary(alice);
        billGenerator.printQuickSummary(bob);
        billGenerator.printQuickSummary(charlie);
        
        // Demonstrate cart operations
        System.out.println("\n=== CART OPERATIONS DEMO ===");
        System.out.println("Alice's cart before clearing: " + alice.getCart().size() + " items");
        alice.removeFromCart("Bread");
        System.out.println("After removing bread: " + alice.getCart().size() + " items");
        billGenerator.printQuickSummary(alice);
    }
}
