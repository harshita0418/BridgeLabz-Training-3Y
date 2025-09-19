import java.util.ArrayList;
import java.util.List;

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        
        SavingsAccount savings = new SavingsAccount("SAV001", "Alice Johnson", 50000, 4.5);
        CurrentAccount current = new CurrentAccount("CUR001", "Bob Smith", 75000, 25000);
        
        accounts.add(savings);
        accounts.add(current);
        
        System.out.println("=== Banking System ===\n");
        for (BankAccount account : accounts) {
            System.out.println("Account: " + account.getAccountNumber());
            System.out.println("Holder: " + account.getHolderName());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Interest: " + account.calculateInterest());
            
            if (account instanceof Loanable) {
                double eligibility = ((Loanable) account).calculateLoanEligibility();
                System.out.println("Loan Eligibility: " + eligibility);
                boolean loanApproved = ((Loanable) account).applyForLoan(30000);
                System.out.println("Loan for 30000 approved: " + loanApproved);
            }
            System.out.println("------------------------");
        }
    }
}
