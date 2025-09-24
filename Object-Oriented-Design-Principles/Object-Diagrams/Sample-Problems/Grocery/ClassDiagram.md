# Grocery Store Bill Generation - Class Diagram

```mermaid
classDiagram
    class Customer {
        -String name
        -String customerId
        -String email
        -List~Product~ cart
        +getName() String
        +getCustomerId() String
        +getEmail() String
        +addToCart(Product) void
        +removeFromCart(String) void
        +clearCart() void
        +getCartTotal() double
    }
    
    class Product {
        -String name
        -double price
        -double quantity
        -String unit
        +getName() String
        +getPrice() double
        +getQuantity() double
        +getUnit() String
        +getTotalCost() double
        +toString() String
    }
    
    class BillGenerator {
        -double TAX_RATE
        -double DISCOUNT_THRESHOLD
        -double DISCOUNT_RATE
        +calculateSubtotal(Customer) double
        +calculateTax(double) double
        +applyDiscount(double) double
        +calculateTotal(Customer) double
        +generateBill(Customer) void
        +printQuickSummary(Customer) void
    }
    
    Customer ||--*{ Product : composition
    BillGenerator ..> Customer : uses
    BillGenerator ..> Product : uses
```