import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double km;
        
        System.out.print("Enter distance in kilometers: ");
        km = input.nextDouble();
        
        double kmToMiles = 0.621371;
        double miles = km * kmToMiles;
        
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
        
        input.close();
    }
}
