public class Truck extends Vehicle implements Insurable {
    private String policyNumber;
    private double loadCapacity;
    
    public Truck(String vehicleNumber, String type, double rentalRate, String policyNumber, double loadCapacity) {
        super(vehicleNumber, type, rentalRate);
        this.policyNumber = policyNumber;
        this.loadCapacity = loadCapacity;
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.5;
    }
    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15;
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + policyNumber + ", Load Capacity: " + loadCapacity + " tons";
    }
    
    public String getPolicyNumber() {
        return policyNumber;
    }
    
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
    
    public double getLoadCapacity() {
        return loadCapacity;
    }
    
    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
