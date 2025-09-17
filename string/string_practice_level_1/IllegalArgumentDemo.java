package string_practice_level_1;

public class IllegalArgumentDemo {
    public static void main(String[] args) {
        try {
            String str = "abcdef";
            System.out.println(str.substring(5, 2)); // start > end
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
    }
}
