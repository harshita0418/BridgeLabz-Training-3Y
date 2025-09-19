import java.util.Scanner;

public class TriangleRunCalculator {
    
    public static int calculateRounds(double side1, double side2, double side3, double targetDistance) {
        double perimeter = side1 + side2 + side3;
        return (int) Math.ceil(targetDistance / perimeter);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter side 1 of triangle (meters): ");
        double side1 = input.nextDouble();
        System.out.print("Enter side 2 of triangle (meters): ");
        double side2 = input.nextDouble();
        System.out.print("Enter side 3 of triangle (meters): ");
        double side3 = input.nextDouble();
        
        double targetDistance = 5000; // 5 km in meters
        int rounds = calculateRounds(side1, side2, side3, targetDistance);
        
        System.out.println("The athlete must complete " + rounds + 
                          " rounds to finish a 5 km run");
        
        input.close();
    }
}O
