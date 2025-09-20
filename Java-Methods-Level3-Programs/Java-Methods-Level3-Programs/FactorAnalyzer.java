class FactorProcessor {
    private int number;
    private int[] factors;
    
    public FactorProcessor(int number) {
        this.number = number;
        this.factors = findFactors();
    }
    
    private int[] findFactors() {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        
        int[] factorArray = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factorArray[index++] = i;
            }
        }
        return factorArray;
    }
    
    public int findGreatestFactor() {
        return factors[factors.length - 2];
    }
    
    public int findSumOfFactors() {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }
    
    public long findProductOfFactors() {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }
    
    public double findProductOfCubes() {
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }
    
    public void displayResults() {
        System.out.println("Number: " + number);
        System.out.print("Factors: ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();
        System.out.println("Greatest Factor: " + findGreatestFactor());
        System.out.println("Sum of Factors: " + findSumOfFactors());
        System.out.println("Product of Factors: " + findProductOfFactors());
        System.out.println("Product of Cubes: " + findProductOfCubes());
    }
}

public class FactorAnalyzer {
    public static void main(String[] args) {
        FactorProcessor processor = new FactorProcessor(12);
        processor.displayResults();
    }
}
