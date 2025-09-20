class DivisorChecker {
    private int number;
    
    public DivisorChecker(int number) {
        this.number = number;
    }
    
    private int[] findProperDivisors() {
        int count = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) count++;
        }
        
        int[] divisors = new int[count];
        int index = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                divisors[index++] = i;
            }
        }
        return divisors;
    }
    
    private int sumOfDivisors(int[] divisors) {
        int sum = 0;
        for (int divisor : divisors) {
            sum += divisor;
        }
        return sum;
    }
    
    public boolean isPerfectNumber() {
        int[] divisors = findProperDivisors();
        int sum = sumOfDivisors(divisors);
        return sum == number;
    }
    
    public boolean isAbundantNumber() {
        int[] divisors = findProperDivisors();
        int sum = sumOfDivisors(divisors);
        return sum > number;
    }
    
    public boolean isDeficientNumber() {
        int[] divisors = findProperDivisors();
        int sum = sumOfDivisors(divisors);
        return sum < number;
    }
    
    public boolean isStrongNumber() {
        int temp = number;
        int sum = 0;
        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == number;
    }
    
    private int factorial(int n) {
        if (n <= 1) return 1;
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    
    public void displayResults() {
        System.out.println("Number: " + number);
        System.out.println("Is Perfect Number: " + isPerfectNumber());
        System.out.println("Is Abundant Number: " + isAbundantNumber());
        System.out.println("Is Deficient Number: " + isDeficientNumber());
        System.out.println("Is Strong Number: " + isStrongNumber());
    }
}

public class NumberChecker5 {
    public static void main(String[] args) {
        DivisorChecker checker = new DivisorChecker(6);
        checker.displayResults();
    }
}
