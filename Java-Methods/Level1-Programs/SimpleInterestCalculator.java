import java.util.Scanner;

public class SimpleInterestCalculator {
    
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter Principal: ");
        double principal = input.nextDouble();
        System.out.print("Enter Rate: ");
        double rate = input.nextDouble();
        System.out.print("Enter Time: ");
        double time = input.nextDouble();
        
        double simpleInterest = calculateSimpleInterest(principal, rate, time);
        
        System.out.println("The Simple Interest is " + simpleInterest + 
                          " for Principal " + principal + 
                          ", Rate of Interest " + rate + " and Time " + time);
        
        input.close();
    }
}
