package string_practice_level_1;

public class ArrayIndexOutOfBoundsDemo {
    public static void main(String[] args) {
        try {
            String[] names = {"A", "B", "C"};
            System.out.println(names[5]); // invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
