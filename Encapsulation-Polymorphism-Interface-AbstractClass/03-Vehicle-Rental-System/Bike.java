public class Bike extends Vehicle implements Insurable {
    private String policyNumber;
    
    public Bike(String vehicleNumber, String type, double rentalRate, String policyNumber) {
        super(vehicleNumber, type, rentalRate);
        this.policyNumber = policyNumber;
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8;
    }
    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + policyNumber;
    }
    
    public String getPolicyNumber() {
        return policyNumber;
    }
    
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
}
