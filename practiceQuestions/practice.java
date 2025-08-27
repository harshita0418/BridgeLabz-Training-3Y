
import java.util.Scanner;
public class practice {
    // 1.
      public static void main(String[] args) {
        System.out.println("Welcome to Bridgelabz!");
    
    // 2. 
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        int sum = num1 + num2;
        System.out.println("Sum = " + sum);

    // 3.   
        Scanner input = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        int celsius = input.nextInt();

        int fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Temperature in Fahrenheit = " + fahrenheit);

    // 4.
        System.out.print("Enter radius of the circle: ");
        double radius = input.nextDouble();

        double area = Math.PI * radius * radius;
        System.out.println("Area of the circle = " + area);

    //5.
        System.out.print("Enter radius of the cylinder: ");
        double r = input.nextDouble();

        System.out.print("Enter height of the cylinder: ");
        double height = input.nextDouble();

        double volume = Math.PI * r * r * height;
        System.out.println("Volume of the cylinder = " + volume);

    // 6.
        System.out.print("Enter Principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter Rate of interest: ");
        double rate = input.nextDouble();

        System.out.print("Enter Time in years: ");
        double time = input.nextDouble();

        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("Simple Interest = " + simpleInterest);

    // 7.
        System.out.print("Enter length of rectangle: ");
        double length = input.nextDouble();

        System.out.print("Enter width of rectangle: ");
        double width = input.nextDouble();

        double perimeter = 2 * (length + width);
        System.out.println("Perimeter of rectangle = " + perimeter);

    // 8.
        System.out.print("Enter base number: ");
        double base = input.nextDouble();

        System.out.print("Enter exponent: ");
        double exponent = input.nextDouble();

        double result = Math.pow(base, exponent);
        System.out.println(result);
    
    // 9.
        System.out.print("Enter first number: ");
        double n1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double n2 = input.nextDouble();

        System.out.print("Enter third number: ");
        double n3 = input.nextDouble();

        double average = (n1 + n2 + n3) / 3;
        System.out.println("Average = " + average);
        
    //10.
        System.out.print("Enter distance in kilometers: ");
        double kilometers = input.nextDouble();

        double miles = kilometers * 0.621371;
        System.out.println(kilometers + " kilometers = " + miles + " miles");
        
    }
}