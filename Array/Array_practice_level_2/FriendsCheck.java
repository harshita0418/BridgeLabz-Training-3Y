package Array_practice_level_2;

import java.util.Scanner;

public class FriendsCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter age and height of " + names[i] + ":");
            ages[i] = input.nextInt();
            heights[i] = input.nextDouble();
        }

        int minAgeIndex = 0, maxHeightIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[minAgeIndex]) minAgeIndex = i;
            if (heights[i] > heights[maxHeightIndex]) maxHeightIndex = i;
        }

        System.out.println("Youngest: " + names[minAgeIndex]);
        System.out.println("Tallest: " + names[maxHeightIndex]);

        input.close();
    }
}
