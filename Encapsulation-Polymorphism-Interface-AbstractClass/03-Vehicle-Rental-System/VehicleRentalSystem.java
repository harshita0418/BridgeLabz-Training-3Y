import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        
        Car car = new Car("KA01AB1234", "Sedan", 2000, "CAR001");
        Bike bike = new Bike("KA02CD5678", "Sport", 500, "BIKE001");
        Truck truck = new Truck("KA03EF9012", "Heavy", 5000, "TRUCK001", 10.0);
        
        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(truck);
        
        int rentalDays = 5;
        
        System.out.println("=== Vehicle Rental System ===\n");
        for (Vehicle vehicle : vehicles) {
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            double insuranceCost = 0;
            
            System.out.println("Vehicle: " + vehicle.getType());
            System.out.println("Number: " + vehicle.getVehicleNumber());
            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);
            
            if (vehicle instanceof Insurable) {
                insuranceCost = ((Insurable) vehicle).calculateInsurance();
                System.out.println("Insurance Cost: " + insuranceCost);
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
            }
            
            System.out.println("Total Cost: " + (rentalCost + insuranceCost));
            System.out.println("------------------------");
        }
    }
}
