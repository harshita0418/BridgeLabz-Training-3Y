class DigitAnalyzer {
    private int number;
    private int[] digits;
    
    public DigitAnalyzer(int number) {
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
    
    public int findSumOfDigits() {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
    
    public int findSumOfSquares() {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }
    
    public boolean isHarshadNumber() {
        int sumOfDigits = findSumOfDigits();
        return number % sumOfDigits == 0;
    }
    
    public int[][] findFrequency() {
        int[] frequency = new int[10];
        for (int digit : digits) {
            frequency[digit]++;
        }
        
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) count++;
        }
        
        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                result[index][0] = i;
                result[index][1] = frequency[i];
                index++;
            }
        }
        return result;
    }
    
    public int getNumber() {
        return number;
    }
    
    public int getDigitCount() {
        return digits.length;
    }
}

public class NumberChecker2 {
    public static void main(String[] args) {
        DigitAnalyzer analyzer = new DigitAnalyzer(21);
        
        System.out.println("Number: " + analyzer.getNumber());
        System.out.println("Digit count: " + analyzer.getDigitCount());
        System.out.println("Sum of digits: " + analyzer.findSumOfDigits());
        System.out.println("Sum of squares: " + analyzer.findSumOfSquares());
        System.out.println("Is Harshad Number: " + analyzer.isHarshadNumber());
        
        int[][] frequency = analyzer.findFrequency();
        System.out.println("Digit frequencies:");
        for (int[] pair : frequency) {
            System.out.println("Digit " + pair[0] + ": " + pair[1] + " times");
        }
    }
}
