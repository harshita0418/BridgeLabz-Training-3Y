
public class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;
    
    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
    
    @Override
    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }
    
    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 3;
    }
    
    public double getInterestRate() {
        return interestRate;
    }
    
    public void setInterestRate(double interestRate) {
        if (interestRate >= 0) {
            this.interestRate = interestRate;
        }
    }
}
