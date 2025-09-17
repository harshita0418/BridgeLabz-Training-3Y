
public class KilometersToMilesConverter {
    public static void main(String[] args) {
        double kilometers = 10.8;
        double milesPerKm = 0.621371;
        double miles = kilometers * milesPerKm;
        
        System.out.println("The distance " + kilometers + " km in miles is " + miles);
    }
}
