package string_practice_level_1;

public class NumberFormatDemo {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("abc"); // invalid number
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        }
    }
}
