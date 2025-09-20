package string_practice_level_2;

import java.util.Scanner;

public class StudentVoting {

    static int[] getAges(int n, Scanner sc) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }
        return ages;
    }

    static String[][] canVote(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) result[i][1] = "Invalid";
            else result[i][1] = (ages[i] >= 18) ? "Can Vote" : "Cannot Vote";
        }
        return result;
    }

    static void displayResult(String[][] table) {
        System.out.printf("%-10s %-12s%n", "Age", "Voting");
        for (String[] row : table) System.out.printf("%-10s %-12s%n", row[0], row[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = getAges(10, sc);
        String[][] table = canVote(ages);
        displayResult(table);
        sc.close();
    }
}
