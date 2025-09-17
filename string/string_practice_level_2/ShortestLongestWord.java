package string_practice_level_2;

import java.util.Scanner;

public class ShortestLongestWord {

    static int getLength(String str) {
        int count = 0;
        try {
            while (true) str.charAt(count++);
        } catch (Exception e) {}
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

    static String[] shortestLongest(String[] words) {
        String shortest = words[0], longest = words[0];
        for (String w : words) {
            if (getLength(w) < getLength(shortest)) shortest = w;
            if (getLength(w) > getLength(longest)) longest = w;
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        String[] words = splitWords(input);
        String[] result = shortestLongest(words);
        System.out.println("Shortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);
        sc.close();
    }
}
