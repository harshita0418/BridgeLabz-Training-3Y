package string_practice_level_2;

import java.util.Scanner;

public class SplitTextCustom {

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
        for (int i = 0; i < n; i++) {
            if (text.charAt(i) == ' ') spaces++;
        }
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

    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        String[] custom = splitWords(input);
        String[] builtin = input.split(" ");
        System.out.println("Match: " + compareArrays(custom, builtin));
        sc.close();
    }
}
