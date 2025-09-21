import java.util.*;

class Employee {
    private String employeeId;
    private String name;
    private String position;
    
    public Employee(String employeeId, String name, String position) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void displayEmployee() {
        System.out.println("Employee: " + name + " (" + position + ")");
    }
}

class Department {
    private String departmentName;
    private ArrayList<Employee> employees;
    
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }
    
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    
    public void displayDepartment() {
        System.out.println("Department: " + departmentName);
        for (Employee emp : employees) {
            System.out.print("  ");
            emp.displayEmployee();
        }
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
}

class Company {
    private String companyName;
    private ArrayList<Department> departments;
    
    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }
    
    public Department createDepartment(String departmentName) {
        Department dept = new Department(departmentName);
        departments.add(dept);
        return dept;
    }
    
    public void displayCompany() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            System.out.print("  ");
            dept.displayDepartment();
        }
    }
    
    public void closeCompany() {
        System.out.println("Company " + companyName + " is being closed.");
        System.out.println("All departments and employees are being removed.");
        departments.clear();
    }
}

public class CompanyAndDepartments {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");
        
        Department itDept = company.createDepartment("IT");
        Department hrDept = company.createDepartment("HR");
        
        Employee emp1 = new Employee("E001", "John", "Software Developer");
        Employee emp2 = new Employee("E002", "Sarah", "System Admin");
        Employee emp3 = new Employee("E003", "Mike", "HR Manager");
        
        itDept.addEmployee(emp1);
        itDept.addEmployee(emp2);
        hrDept.addEmployee(emp3);
        
        company.displayCompany();
        
        System.out.println("\n--- Composition Demonstration ---");
        company.closeCompany();
        
        System.out.println("\nAfter company closure:");
        company.displayCompany();
    }
}
