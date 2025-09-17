import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your height in centimeters: ");
        double heightInCm = input.nextDouble();
        
        double cmPerInch = 2.54;
        double inchesPerFoot = 12;
        
        double totalInches = heightInCm / cmPerInch;
        int feet = (int) (totalInches / inchesPerFoot);
        double remainingInches = totalInches % inchesPerFoot;
        
        System.out.println("Your Height in cm is " + heightInCm + " while in feet is " + feet + " and inches is " + remainingInches);
        
        input.close();
    }
}
