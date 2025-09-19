import java.util.Scanner;

public class QuotientRemainderCalculator {
    
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{remainder, quotient};
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int number = input.nextInt();
        System.out.print("Enter second number (divisor): ");
        int divisor = input.nextInt();
        
        int[] result = findRemainderAndQuotient(number, divisor);
        
        System.out.println("Quotient: " + result[1]);
        System.out.println("Remainder: " + result[0]);
        
        input.close();
    }
}
