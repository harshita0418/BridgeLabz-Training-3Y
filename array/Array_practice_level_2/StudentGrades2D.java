package Array_practice_level_2;

import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        double[][] marks = new double[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks in Physics, Chemistry, Maths for student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                double mark = input.nextDouble();
                if (mark < 0) {
                    System.out.println("Invalid marks. Try again.");
                    j--; continue;
                }
                marks[i][j] = mark;
            }
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3;

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
