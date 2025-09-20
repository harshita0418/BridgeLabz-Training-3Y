package string_practice_level_1;

import java.util.Scanner;

public class CharArrayDemo {

    // User-defined method to convert string to char array
    public static char[] toCharArrayManual(String text) {
        char[] arr = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = text.charAt(i);
        }
        return arr;
    }

    // Compare two char arrays
    public static boolean compareArrays(char[] a1, char[] a2) {
        if (a1.length != a2.length) return false;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] userDefined = toCharArrayManual(text);
        char[] builtIn = text.toCharArray();

        System.out.println("Are both arrays equal? " + compareArrays(userDefined, builtIn));
    }
}
