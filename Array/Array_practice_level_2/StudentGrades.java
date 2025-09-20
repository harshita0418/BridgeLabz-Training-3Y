package Array_practice_level_2;

import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        double[] physics = new double[n];
        double[] chemistry = new double[n];
        double[] maths = new double[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks in Physics, Chemistry, Maths for student " + (i + 1) + ":");
            double p = input.nextDouble();
            double c = input.nextDouble();
            double m = input.nextDouble();

            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Invalid marks. Try again.");
                i--;
                continue;
            }

            physics[i] = p; chemistry[i] = c; maths[i] = m;
            percentage[i] = (p + c + m) / 3;

            if (percentage[i] >= 90) grade[i] = 'A';
            else if (percentage[i] >= 75) grade[i] = 'B';
            else if (percentage[i] >= 50) grade[i] = 'C';
            else grade[i] = 'D';
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": %=" + percentage[i] + ", Grade=" + grade[i]);
        }

        input.close();
    }
}
