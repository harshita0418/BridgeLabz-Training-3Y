import java.util.*;

class Customer {
    private String customerId;
    private String name;
    private double balance;
    private Bank associatedBank;
    
    public Customer(String customerId, String name, Bank bank) {
        this.customerId = customerId;
        this.name = name;
        this.balance = 0.0;
        this.associatedBank = bank;
    }
    
    public String getCustomerId() {
        return customerId;
    }
    
    public String getName() {
        return name;
    }
    
    public double viewBalance() {
        System.out.println("Customer: " + name + ", Balance: $" + balance);
        return balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " to " + name + "'s account");
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from " + name + "'s account");
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class Bank {
    private String bankName;
    private ArrayList<Customer> customers;
    
    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }
    
    public Customer openAccount(String customerId, String customerName) {
        Customer customer = new Customer(customerId, customerName, this);
        customers.add(customer);
        System.out.println("Account opened for " + customerName + " at " + bankName);
        return customer;
    }
    
    public void displayCustomers() {
        System.out.println("Customers at " + bankName + ":");
        for (Customer customer : customers) {
            System.out.println("- " + customer.getName() + " (ID: " + customer.getCustomerId() + ")");
        }
    }
}

public class BankAndAccountHolders {
    public static void main(String[] args) {
        Bank sbiBank = new Bank("State Bank of India");
        Bank hdfcBank = new Bank("HDFC Bank");
        
        Customer customer1 = sbiBank.openAccount("C001", "Alice");
        Customer customer2 = sbiBank.openAccount("C002", "Bob");
        Customer customer3 = hdfcBank.openAccount("C003", "Charlie");
        
        customer1.deposit(1000);
        customer1.viewBalance();
        customer1.withdraw(200);
        customer1.viewBalance();
        
        System.out.println();
        sbiBank.displayCustomers();
        System.out.println();
        hdfcBank.displayCustomers();
    }
}
