package string_practice_level_2;

import java.util.Scanner;

public class VowelsConsonantsType {

    static String charType(char c) {
        if (!Character.isLetter(c)) return "Not a Letter";
        c = Character.toLowerCase(c);
        if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return "Vowel";
        return "Consonant";
    }

    static String[][] analyzeText(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = charType(text.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        String[][] table = analyzeText(input);
        System.out.printf("%-5s %-12s%n", "Char", "Type");
        for (String[] row : table) System.out.printf("%-5s %-12s%n", row[0], row[1]);
        sc.close();
    }
}
