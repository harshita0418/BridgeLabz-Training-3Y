public class OutPatient extends Patient implements MedicalRecord {
    private int consultationFee;
    private String medicalHistory;
    
    public OutPatient(int patientId, String name, int age, int consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalHistory = "";
    }
    
    @Override
    public double calculateBill() {
        return consultationFee + 200;
    }
    
    @Override
    public void addRecord(String record) {
        medicalHistory += record + "; ";
    }
    
    @Override
    public String viewRecords() {
        return "Medical History: " + medicalHistory;
    }
    
    public int getConsultationFee() {
        return consultationFee;
    }
    
    public void setConsultationFee(int consultationFee) {
        if (consultationFee > 0) {
            this.consultationFee = consultationFee;
        }
    }
}
