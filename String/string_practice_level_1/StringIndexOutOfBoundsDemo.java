package string_practice_level_1;

public class StringIndexOutOfBoundsDemo {
    public static void main(String[] args) {
        try {
            String str = "Hello";
            System.out.println(str.charAt(10)); // invalid index
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
