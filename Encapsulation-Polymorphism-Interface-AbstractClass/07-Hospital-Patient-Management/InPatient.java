public class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private String medicalHistory;
    
    public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
        this.medicalHistory = "";
    }
    
    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge + 5000;
    }
    
    @Override
    public void addRecord(String record) {
        medicalHistory += record + "; ";
    }
    
    @Override
    public String viewRecords() {
        return "Medical History: " + medicalHistory;
    }
    
    public int getDaysAdmitted() {
        return daysAdmitted;
    }
    
    public void setDaysAdmitted(int daysAdmitted) {
        if (daysAdmitted > 0) {
            this.daysAdmitted = daysAdmitted;
        }
    }
}
