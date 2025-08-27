package string_practice_level_1;

public class NullPointerDemo {
    public static void main(String[] args) {
        try {
            String text = null;
            System.out.println(text.length()); // throws exception
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }
}
