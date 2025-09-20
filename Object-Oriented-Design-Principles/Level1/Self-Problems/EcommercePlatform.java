import java.util.*;

class Product {
    private String productId;
    private String name;
    private double price;
    private int quantity;
    
    public Product(String productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getTotalPrice() {
        return price * quantity;
    }
    
    public void displayProduct() {
        System.out.println("Product: " + name + " | Price: $" + price + " | Qty: " + quantity + " | Total: $" + getTotalPrice());
    }
}

class Order {
    private String orderId;
    private ArrayList<Product> products;
    private double totalAmount;
    
    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
        this.totalAmount = 0.0;
    }
    
    public void addProduct(Product product) {
        products.add(product);
        calculateTotal();
    }
    
    private void calculateTotal() {
        totalAmount = 0.0;
        for (Product product : products) {
            totalAmount += product.getTotalPrice();
        }
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products:");
        for (Product product : products) {
            System.out.print("  ");
            product.displayProduct();
        }
        System.out.println("Total Order Amount: $" + totalAmount);
    }
}

class Customer {
    private String customerId;
    private String name;
    private String email;
    private ArrayList<Order> orders;
    
    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }
    
    public Order placeOrder(String orderId) {
        Order order = new Order(orderId);
        orders.add(order);
        System.out.println("Order " + orderId + " placed by " + name);
        return order;
    }
    
    public String getName() {
        return name;
    }
    
    public void viewOrderHistory() {
        System.out.println("Order History for " + name + ":");
        for (Order order : orders) {
            System.out.println("  Order: " + order.getOrderId() + " | Amount: $" + order.getTotalAmount());
        }
    }
    
    public void displayCustomer() {
        System.out.println("Customer: " + name + " | Email: " + email + " | Total Orders: " + orders.size());
    }
}

class EcommercePlatform {
    private String platformName;
    private ArrayList<Customer> customers;
    private ArrayList<Order> allOrders;
    
    public EcommercePlatform(String platformName) {
        this.platformName = platformName;
        this.customers = new ArrayList<>();
        this.allOrders = new ArrayList<>();
    }
    
    public void registerCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer " + customer.getName() + " registered on " + platformName);
    }
    
    public void processOrder(Order order) {
        allOrders.add(order);
        System.out.println("Order " + order.getOrderId() + " processed on " + platformName);
    }
    
    public void displayPlatformStats() {
        System.out.println("Platform: " + platformName);
        System.out.println("Total Customers: " + customers.size());
        System.out.println("Total Orders: " + allOrders.size());
    }
}

public class EcommercePlatformDemo {
    public static void main(String[] args) {
        EcommercePlatform platform = new EcommercePlatform("ShopEasy");
        
        Customer customer1 = new Customer("C001", "Alice", "alice@email.com");
        Customer customer2 = new Customer("C002", "Bob", "bob@email.com");
        
        platform.registerCustomer(customer1);
        platform.registerCustomer(customer2);
        
        Order order1 = customer1.placeOrder("ORD001");
        Product product1 = new Product("P001", "Laptop", 999.99, 1);
        Product product2 = new Product("P002", "Mouse", 29.99, 2);
        order1.addProduct(product1);
        order1.addProduct(product2);
        
        Order order2 = customer2.placeOrder("ORD002");
        Product product3 = new Product("P003", "Keyboard", 79.99, 1);
        Product product4 = new Product("P004", "Monitor", 299.99, 1);
        order2.addProduct(product3);
        order2.addProduct(product4);
        
        platform.processOrder(order1);
        platform.processOrder(order2);
        
        System.out.println("\n--- Order Details ---");
        order1.displayOrder();
        System.out.println();
        order2.displayOrder();
        
        System.out.println("\n--- Customer Order History ---");
        customer1.viewOrderHistory();
        
        System.out.println("\n--- Platform Statistics ---");
        platform.displayPlatformStats();
    }
}
