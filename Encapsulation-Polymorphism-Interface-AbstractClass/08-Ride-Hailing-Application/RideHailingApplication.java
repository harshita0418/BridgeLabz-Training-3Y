import java.util.ArrayList;
import java.util.List;

public class RideHailingApplication {
    
    public static void calculateFares(List<Vehicle> vehicles, double distance) {
        System.out.println("=== Ride-Hailing Application ===\n");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getVehicleDetails());
            
            if (vehicle instanceof GPS) {
                ((GPS) vehicle).updateLocation("Downtown");
                System.out.println("Current Location: " + ((GPS) vehicle).getCurrentLocation());
            }
            
            double fare = vehicle.calculateFare(distance);
            System.out.println("Fare for " + distance + " km: " + fare);
            System.out.println("------------------------");
        }
    }
    
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        
        Car car = new Car("CAR001", "Alice Johnson", 12);
        Bike bike = new Bike("BIKE001", "Bob Smith", 8);
        Auto auto = new Auto("AUTO001", "Charlie Brown", 10);
        
        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(auto);
        
        calculateFares(vehicles, 15.0);
    }
}
