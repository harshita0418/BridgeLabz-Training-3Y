package string_practice_level_2;

import java.util.Scanner;

public class WordsWithLength {

    static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    static String[] splitWords(String text) {
        int n = getLength(text);
        int spaces = 0;
        for (int i = 0; i < n; i++) if (text.charAt(i) == ' ') spaces++;
        String[] words = new String[spaces + 1];
        int start = 0, index = 0;
        for (int i = 0; i <= n; i++) {
            if (i == n || text.charAt(i) == ' ') {
                words[index++] = text.substring(start, i);
                start = i + 1;
            }
        }
        return words;
    }

    static String[][] wordsWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        String[] words = splitWords(input);
        String[][] table = wordsWithLength(words);
        System.out.printf("%-15s %-10s%n", "Word", "Length");
        for (String[] row : table) System.out.printf("%-15s %-10s%n", row[0], row[1]);
        sc.close();
    }
}
