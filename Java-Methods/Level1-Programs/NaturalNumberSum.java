import java.util.Scanner;

public class NaturalNumberSum {
    
    public static int findSumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        
        if (n > 0) {
            int sum = findSumOfNaturalNumbers(n);
            System.out.println("The sum of " + n + " natural numbers is " + sum);
        } else {
            System.out.println("Please enter a positive number");
        }
        
        input.close();
    }
}
