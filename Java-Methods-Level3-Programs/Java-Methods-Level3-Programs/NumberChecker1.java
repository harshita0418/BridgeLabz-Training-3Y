class NumberAnalyzer {
    private int number;
    private int[] digits;
    
    public NumberAnalyzer(int number) {
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
    
    public boolean isDuckNumber() {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isArmstrongNumber() {
        int sum = 0;
        int power = digits.length;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }
    
    public int[] findLargestAndSecondLargest() {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        return new int[]{largest, secondLargest};
    }
    
    public int[] findSmallestAndSecondSmallest() {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        return new int[]{smallest, secondSmallest};
    }
    
    public void displayResults() {
        System.out.println("Number: " + number);
        System.out.println("Digit count: " + countDigits());
        System.out.println("Is Duck Number: " + isDuckNumber());
        System.out.println("Is Armstrong Number: " + isArmstrongNumber());
        
        int[] largestPair = findLargestAndSecondLargest();
        System.out.println("Largest: " + largestPair[0] + ", Second Largest: " + largestPair[1]);
        
        int[] smallestPair = findSmallestAndSecondSmallest();
        System.out.println("Smallest: " + smallestPair[0] + ", Second Smallest: " + smallestPair[1]);
    }
}

public class NumberChecker1 {
    public static void main(String[] args) {
        NumberAnalyzer analyzer = new NumberAnalyzer(153);
        analyzer.displayResults();
    }
}
