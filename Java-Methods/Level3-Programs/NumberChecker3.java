class PalindromeChecker {
    private int number;
    private int[] digits;
    
    public PalindromeChecker(int number) {
        this.number = number;
        this.digits = storeDigits();
    }
    
    private int countDigits() {
        int count = 0;
        int temp = number;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }
    
    private int[] storeDigits() {
        int count = countDigits();
        int[] digitArray = new int[count];
        int temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digitArray[i] = temp % 10;
            temp /= 10;
        }
        return digitArray;
    }
    
    public int[] reverseDigits() {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }
    
    public boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
    
    public boolean isPalindrome() {
        int[] reversed = reverseDigits();
        return compareArrays(digits, reversed);
    }
    
    public boolean isDuckNumber() {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }
    
    public void displayResults() {
        System.out.println("Number: " + number);
        System.out.println("Digit count: " + countDigits());
        System.out.println("Is Palindrome: " + isPalindrome());
        System.out.println("Is Duck Number: " + isDuckNumber());
        
        int[] reversed = reverseDigits();
        System.out.print("Reversed digits: ");
        for (int digit : reversed) {
            System.out.print(digit + " ");
        }
        System.out.println();
    }
}

public class NumberChecker3 {
    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker(121);
        checker.displayResults();
    }
}
