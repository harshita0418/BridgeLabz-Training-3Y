import java.util.*;

class Faculty {
    private String facultyId;
    private String name;
    private String specialization;
    
    public Faculty(String facultyId, String name, String specialization) {
        this.facultyId = facultyId;
        this.name = name;
        this.specialization = specialization;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    public void displayFaculty() {
        System.out.println("Faculty: " + name + " (" + specialization + ")");
    }
}

class Department {
    private String departmentName;
    private ArrayList<Faculty> facultyMembers;
    
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.facultyMembers = new ArrayList<>();
    }
    
    public void assignFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }
    
    public void displayDepartment() {
        System.out.println("Department: " + departmentName);
        for (Faculty faculty : facultyMembers) {
            System.out.print("  ");
            faculty.displayFaculty();
        }
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
}

class University {
    private String universityName;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> allFaculty;
    
    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.allFaculty = new ArrayList<>();
    }
    
    public Department createDepartment(String departmentName) {
        Department dept = new Department(departmentName);
        departments.add(dept);
        System.out.println("Department " + departmentName + " created in " + universityName);
        return dept;
    }
    
    public void hireFaculty(Faculty faculty) {
        allFaculty.add(faculty);
        System.out.println("Faculty " + faculty.getName() + " hired at " + universityName);
    }
    
    public void displayUniversity() {
        System.out.println("University: " + universityName);
        System.out.println("Departments:");
        for (Department dept : departments) {
            System.out.print("  ");
            dept.displayDepartment();
        }
        System.out.println("Independent Faculty:");
        for (Faculty faculty : allFaculty) {
            System.out.print("  ");
            faculty.displayFaculty();
        }
    }
    
    public void closeUniversity() {
        System.out.println("University " + universityName + " is closing.");
        System.out.println("All departments are being dissolved.");
        departments.clear();
        System.out.println("Faculty members exist independently and can join other universities.");
    }
}

public class UniversityFacultiesDepartments {
    public static void main(String[] args) {
        University university = new University("Tech University");
        
        Faculty faculty1 = new Faculty("F001", "Dr. Smith", "Computer Science");
        Faculty faculty2 = new Faculty("F002", "Dr. Johnson", "Mathematics");
        Faculty faculty3 = new Faculty("F003", "Dr. Brown", "Physics");
        
        university.hireFaculty(faculty1);
        university.hireFaculty(faculty2);
        university.hireFaculty(faculty3);
        
        Department csDept = university.createDepartment("Computer Science");
        Department mathDept = university.createDepartment("Mathematics");
        
        csDept.assignFaculty(faculty1);
        mathDept.assignFaculty(faculty2);
        
        university.displayUniversity();
        
        System.out.println("\n--- Composition vs Aggregation Demo ---");
        university.closeUniversity();
        
        System.out.println("\nFaculty still exists independently:");
        faculty1.displayFaculty();
        faculty2.displayFaculty();
        faculty3.displayFaculty();
    }
}
