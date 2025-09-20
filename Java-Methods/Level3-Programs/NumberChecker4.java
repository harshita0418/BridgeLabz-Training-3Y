class SpecialNumberChecker {
    private int number;
    
    public SpecialNumberChecker(int number) {
        this.number = number;
    }
    
    public boolean isPrimeNumber() {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
    
    public boolean isNeonNumber() {
        int square = number * number;
        int sumOfSquareDigits = 0;
        while (square > 0) {
            sumOfSquareDigits += square % 10;
            square /= 10;
        }
        return sumOfSquareDigits == number;
    }
    
    public boolean isSpyNumber() {
        int sum = 0;
        int product = 1;
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }
    
    public boolean isAutomorphicNumber() {
        int square = number * number;
        int temp = number;
        int digits = 0;
        while (temp > 0) {
            digits++;
            temp /= 10;
        }
        int lastDigits = square % (int) Math.pow(10, digits);
        return lastDigits == number;
    }
    
    public boolean isBuzzNumber() {
        return (number % 7 == 0) || (number % 10 == 7);
    }
    
    public void displayResults() {
        System.out.println("Number: " + number);
        System.out.println("Is Prime Number: " + isPrimeNumber());
        System.out.println("Is Neon Number: " + isNeonNumber());
        System.out.println("Is Spy Number: " + isSpyNumber());
        System.out.println("Is Automorphic Number: " + isAutomorphicNumber());
        System.out.println("Is Buzz Number: " + isBuzzNumber());
    }
}

public class NumberChecker4 {
    public static void main(String[] args) {
        SpecialNumberChecker checker = new SpecialNumberChecker(7);
        checker.displayResults();
    }
}
