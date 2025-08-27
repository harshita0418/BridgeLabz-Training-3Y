package string_practice_level_1;

import java.util.Scanner;

public class LowercaseDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String str = sc.nextLine();

        String manual = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                manual += (char)(ch + 32);
            } else {
                manual += ch;
            }
        }

        String builtIn = str.toLowerCase();

        System.out.println("Manual lowercase: " + manual);
        System.out.println("Built-in lowercase: " + builtIn);
    }
}
