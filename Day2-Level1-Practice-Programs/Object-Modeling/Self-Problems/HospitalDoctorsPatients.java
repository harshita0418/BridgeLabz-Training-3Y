import java.util.*;

class Patient {
    private String patientId;
    private String name;
    private int age;
    private ArrayList<Doctor> consultedDoctors;
    
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.consultedDoctors = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public String getPatientId() {
        return patientId;
    }
    
    public void addConsultedDoctor(Doctor doctor) {
        if (!consultedDoctors.contains(doctor)) {
            consultedDoctors.add(doctor);
        }
    }
    
    public void displayPatient() {
        System.out.println("Patient: " + name + " (ID: " + patientId + ", Age: " + age + ")");
    }
    
    public void viewConsultationHistory() {
        System.out.println(name + " has consulted:");
        for (Doctor doctor : consultedDoctors) {
            System.out.println("  - Dr. " + doctor.getName() + " (" + doctor.getSpecialty() + ")");
        }
    }
}

class Doctor {
    private String doctorId;
    private String name;
    private String specialty;
    private ArrayList<Patient> patients;
    
    public Doctor(String doctorId, String name, String specialty) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialty = specialty;
        this.patients = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public String getSpecialty() {
        return specialty;
    }
    
    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
        patient.addConsultedDoctor(this);
        System.out.println("Dr. " + name + " is consulting with " + patient.getName());
        System.out.println("Consultation completed successfully.");
    }
    
    public void displayDoctor() {
        System.out.println("Doctor: Dr. " + name + " (" + specialty + ")");
    }
    
    public void viewPatientList() {
        System.out.println("Dr. " + name + " has treated:");
        for (Patient patient : patients) {
            System.out.println("  - " + patient.getName());
        }
    }
}

class Hospital {
    private String hospitalName;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;
    
    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }
    
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Dr. " + doctor.getName() + " joined " + hospitalName);
    }
    
    public void registerPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient " + patient.getName() + " registered at " + hospitalName);
    }
    
    public void displayHospitalInfo() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Total Doctors: " + doctors.size());
        System.out.println("Total Patients: " + patients.size());
    }
}

public class HospitalDoctorsPatients {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City General Hospital");
        
        Doctor doctor1 = new Doctor("D001", "Smith", "Cardiology");
        Doctor doctor2 = new Doctor("D002", "Johnson", "Neurology");
        Doctor doctor3 = new Doctor("D003", "Brown", "General Medicine");
        
        Patient patient1 = new Patient("P001", "Alice", 35);
        Patient patient2 = new Patient("P002", "Bob", 42);
        Patient patient3 = new Patient("P003", "Charlie", 28);
        
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addDoctor(doctor3);
        
        hospital.registerPatient(patient1);
        hospital.registerPatient(patient2);
        hospital.registerPatient(patient3);
        
        System.out.println("\n--- Consultations ---");
        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient1);
        doctor3.consult(patient3);
        
        System.out.println("\n--- Hospital Info ---");
        hospital.displayHospitalInfo();
        
        System.out.println("\n--- Patient History ---");
        patient1.viewConsultationHistory();
        
        System.out.println("\n--- Doctor Patient List ---");
        doctor1.viewPatientList();
    }
}
