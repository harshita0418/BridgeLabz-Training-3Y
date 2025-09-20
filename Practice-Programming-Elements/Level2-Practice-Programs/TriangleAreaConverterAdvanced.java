import java.util.Scanner;

public class TriangleAreaConverterAdvanced {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter base in cm: ");
        double base = input.nextDouble();
        
        System.out.print("Enter height in cm: ");
        double height = input.nextDouble();
        
        double areaInSqCm = 0.5 * base * height;
        double cmToInch = 2.54;
        double areaInSqIn = areaInSqCm / (cmToInch * cmToInch);
        
        System.out.println("The Area of the triangle in sq in is " + areaInSqIn + " and sq cm is " + areaInSqCm);
        
        input.close();
    }
}
