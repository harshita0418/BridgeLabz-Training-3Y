class GeometryCalculator {
    private double x1, y1, x2, y2, x3, y3;
    
    public GeometryCalculator(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }
    
    public boolean checkCollinearUsingSlope() {
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);
        return slopeAB == slopeBC && slopeBC == slopeAC;
    }
    
    public boolean checkCollinearUsingArea() {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return Math.abs(area) == 0;
    }
    
    public void displayResults() {
        System.out.println("Points: A(" + x1 + "," + y1 + "), B(" + x2 + "," + y2 + "), C(" + x3 + "," + y3 + ")");
        System.out.println("Collinear using slope method: " + checkCollinearUsingSlope());
        System.out.println("Collinear using area method: " + checkCollinearUsingArea());
    }
}

public class CollinearPointsChecker {
    public static void main(String[] args) {
        GeometryCalculator calculator = new GeometryCalculator(2, 4, 4, 6, 6, 8);
        calculator.displayResults();
    }
}
