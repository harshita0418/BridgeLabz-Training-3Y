import java.util.Scanner;

public class TriangleAreaCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter base of triangle: ");
        double base = input.nextDouble();
        
        System.out.print("Enter height of triangle: ");
        double height = input.nextDouble();
        
        double areaSquareInches = 0.5 * base * height;
        double cmToInchConversion = 2.54;
        double areaSquareCm = areaSquareInches * cmToInchConversion * cmToInchConversion;
        
        System.out.println("The Area of triangle in square inches is " + areaSquareInches + 
                          " and in square centimeters is " + areaSquareCm);
        
        input.close();
    }
}
