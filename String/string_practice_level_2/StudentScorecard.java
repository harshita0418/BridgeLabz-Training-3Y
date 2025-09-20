package string_practice_level_2;

import java.util.Scanner;

public class StudentScorecard {

    static int[][] generateScores(int n) {
        int[][] scores = new int[n][3]; // 3 subjects
        for (int i = 0; i < n; i++) {
            scores[i][0] = 40 + (int)(Math.random() * 61); // Physics 40-100
            scores[i][1] = 40 + (int)(Math.random() * 61); // Chemistry
            scores[i][2] = 40 + (int)(Math.random() * 61); // Maths
        }
        return scores;
    }

    static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3]; // total, avg, perc
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = Math.round(total / 3.0 * 100.0) / 100.0;
            double perc = Math.round(total * 100.0 / 300 * 100.0) / 100.0;
            stats[i][0] = total;
            stats[i][1] = avg;
            stats[i][2] = perc;
        }
        return stats;
    }

    static String[] calculateGrades(double[][] stats) {
        String[] grades = new String[stats.length];
        for (int i = 0; i < stats.length; i++) {
            double perc = stats[i][2];
            if (perc >= 80) grades[i] = "A";
            else if (perc >= 70) grades[i] = "B";
            else if (perc >= 60) grades[i] = "C";
            else if (perc >= 50) grades[i] = "D";
            else if (perc >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    static void displayScorecard(int[][] scores, double[][] stats, String[] grades) {
        System.out.printf("%-8s %-8s %-8s %-8s %-8s %-8s %-6s%n",
                "Physics","Chem","Maths","Total","Average","Percent","Grade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-8d %-8d %-8d %-8.0f %-8.2f %-8.2f %-6s%n",
                    scores[i][0], scores[i][1], scores[i][2],
                    stats[i][0], stats[i][1], stats[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = generateScores(n);
        double[][] stats = calculateStats(scores);
        String[] grades = calculateGrades(stats);

        displayScorecard(scores, stats, grades);
        sc.close();
    }
}
