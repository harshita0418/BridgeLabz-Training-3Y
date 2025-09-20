class CompanyBonusSystem {
    private double[][] employeeData;
    private final int EMPLOYEE_COUNT = 10;
    
    public CompanyBonusSystem() {
        this.employeeData = new double[EMPLOYEE_COUNT][2];
        generateEmployeeData();
    }
    
    private void generateEmployeeData() {
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            employeeData[i][0] = (int) (Math.random() * 90000) + 10000;
            employeeData[i][1] = (int) (Math.random() * 15) + 1;
        }
    }
    
    public double[][] calculateNewSalaryAndBonus() {
        double[][] result = new double[EMPLOYEE_COUNT][2];
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            double salary = employeeData[i][0];
            double years = employeeData[i][1];
            double bonusPercentage = (years > 5) ? 0.05 : 0.02;
            double bonus = salary * bonusPercentage;
            double newSalary = salary + bonus;
            result[i][0] = newSalary;
            result[i][1] = bonus;
        }
        return result;
    }
    
    public double[] calculateTotals() {
        double[][] bonusData = calculateNewSalaryAndBonus();
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;
        
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            totalOldSalary += employeeData[i][0];
            totalNewSalary += bonusData[i][0];
            totalBonus += bonusData[i][1];
        }
        return new double[]{totalOldSalary, totalNewSalary, totalBonus};
    }
    
    public void displayResults() {
        double[][] bonusData = calculateNewSalaryAndBonus();
        double[] totals = calculateTotals();
        
        System.out.println("Employee Bonus Calculation");
        System.out.println("Emp#\tOld Salary\tYears\tNew Salary\tBonus");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.printf("%d\t%.0f\t\t%.0f\t%.0f\t\t%.0f\n", 
                i+1, employeeData[i][0], employeeData[i][1], 
                bonusData[i][0], bonusData[i][1]);
        }
        System.out.printf("Total:\t%.0f\t\t\t%.0f\t\t%.0f\n", 
            totals[0], totals[1], totals[2]);
    }
}

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        CompanyBonusSystem bonusSystem = new CompanyBonusSystem();
        bonusSystem.displayResults();
    }
}
