import java.util.ArrayList;
import java.util.List;

public class HospitalPatientManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        
        InPatient inPatient = new InPatient(1, "John Doe", 45, 5, 2000);
        inPatient.addRecord("Admitted for surgery");
        inPatient.addRecord("Post-operative care");
        
        OutPatient outPatient = new OutPatient(2, "Jane Smith", 30, 500);
        outPatient.addRecord("Regular checkup");
        outPatient.addRecord("Blood pressure monitoring");
        
        patients.add(inPatient);
        patients.add(outPatient);
        
        System.out.println("=== Hospital Patient Management ===\n");
        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails());
            System.out.println("Bill Amount: " + patient.calculateBill());
            
            if (patient instanceof MedicalRecord) {
                System.out.println(((MedicalRecord) patient).viewRecords());
            }
            System.out.println("------------------------");
        }
    }
}
