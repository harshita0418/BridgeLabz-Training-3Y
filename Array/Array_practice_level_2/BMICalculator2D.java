package Array_practice_level_2;

import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = input.nextInt();

        double[][] personData = new double[n][3]; // weight, height, BMI
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter height (m) and weight (kg) for person " + (i + 1) + ":");
            double h = input.nextDouble();
            double w = input.nextDouble();

            if (h <= 0 || w <= 0) {
                System.out.println("Invalid input. Try again.");
                i--;
                continue;
            }

            personData[i][0] = w;
            personData[i][1] = h;
            personData[i][2] = w / (h * h);

            if (personData[i][2] < 18.5) status[i] = "Underweight";
            else if (personData[i][2] < 25) status[i] = "Normal";
            else if (personData[i][2] < 30) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ": Height=" + personData[i][1] + "m, Weight=" +
                    personData[i][0] + "kg, BMI=" + personData[i][2] + ", Status=" + status[i]);
        }

        input.close();
    }
}
