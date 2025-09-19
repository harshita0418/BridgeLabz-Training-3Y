import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        FullTimeEmployee fullTime = new FullTimeEmployee(1, "John Doe", 50000);
        fullTime.assignDepartment("IT");
        
        PartTimeEmployee partTime = new PartTimeEmployee(2, "Jane Smith", 0, 20, 25.0);
        partTime.assignDepartment("HR");
        
        employees.add(fullTime);
        employees.add(partTime);
        
        System.out.println("=== Employee Management System ===\n");
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
            }
            System.out.println("------------------------");
        }
    }
}
