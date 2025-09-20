class PointCalculator {
    private double x1, y1, x2, y2;
    
    public PointCalculator(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public double calculateEuclideanDistance() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    
    public double[] findLineEquation() {
        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;
        return new double[]{slope, yIntercept};
    }
    
    public void displayResults() {
        System.out.println("Points: P1(" + x1 + "," + y1 + "), P2(" + x2 + "," + y2 + ")");
        System.out.println("Euclidean Distance: " + calculateEuclideanDistance());
        
        double[] equation = findLineEquation();
        System.out.println("Line Equation: y = " + equation[0] + "x + " + equation[1]);
    }
}

public class EuclideanDistanceCalculator {
    public static void main(String[] args) {
        PointCalculator calculator = new PointCalculator(1, 2, 4, 6);
        calculator.displayResults();
    }
}
