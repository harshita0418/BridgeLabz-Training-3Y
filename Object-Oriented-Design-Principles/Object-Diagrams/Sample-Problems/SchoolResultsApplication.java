import java.util.*;

// Subject class representing individual subjects with marks
class Subject {
    private String name;
    private double marks;
    
    public Subject(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
    
    public String getName() {
        return name;
    }
    
    public double getMarks() {
        return marks;
    }
    
    public void setMarks(double marks) {
        this.marks = marks;
    }
    
    @Override
    public String toString() {
        return name + ": " + marks;
    }
}

// Student class with aggregation relationship to Subject
class Student {
    private String name;
    private String id;
    private List<Subject> subjects;
    
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.subjects = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }
    
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
    
    public List<Subject> getSubjects() {
        return subjects;
    }
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', id='" + id + "', subjects=" + subjects + "}";
    }
}

// GradeCalculator class for computing grades
class GradeCalculator {
    
    public String calculateGrade(double marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }
    
    public double getGradePoint(String grade) {
        switch (grade) {
            case "A+": return 4.0;
            case "A": return 3.7;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            default: return 0.0;
        }
    }
    
    public void generateResult(Student student) {
        System.out.println("\n=== STUDENT RESULT ===");
        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getId());
        System.out.println("------------------------");
        
        double totalMarks = 0;
        int subjectCount = 0;
        
        for (Subject subject : student.getSubjects()) {
            double marks = subject.getMarks();
            String grade = calculateGrade(marks);
            double gradePoint = getGradePoint(grade);
            
            System.out.printf("%-12s: %.1f  Grade: %s  GP: %.1f%n", 
                subject.getName(), marks, grade, gradePoint);
            
            totalMarks += marks;
            subjectCount++;
        }
        
        if (subjectCount > 0) {
            double average = totalMarks / subjectCount;
            String overallGrade = calculateGrade(average);
            double overallGP = getGradePoint(overallGrade);
            
            System.out.println("------------------------");
            System.out.printf("Average: %.2f%n", average);
            System.out.printf("Overall Grade: %s%n", overallGrade);
            System.out.printf("Overall GP: %.2f%n", overallGP);
        }
        System.out.println("========================");
    }
}

// Main application class
public class SchoolResultsApplication {
    public static void main(String[] args) {
        // Create student instance
        Student john = new Student("John Smith", "S001");
        
        // Create subject instances
        Subject math = new Subject("Mathematics", 92.0);
        Subject science = new Subject("Science", 85.0);
        Subject english = new Subject("English", 78.0);
        Subject history = new Subject("History", 88.0);
        
        // Add subjects to student (demonstrating aggregation)
        john.addSubject(math);
        john.addSubject(science);
        john.addSubject(english);
        john.addSubject(history);
        
        // Create grade calculator
        GradeCalculator calculator = new GradeCalculator();
        
        // Generate and display results
        calculator.generateResult(john);
        
        // Demonstrate individual grade calculation
        System.out.println("\n=== INDIVIDUAL CALCULATIONS ===");
        for (Subject subject : john.getSubjects()) {
            String grade = calculator.calculateGrade(subject.getMarks());
            System.out.printf("%s (%.1f) -> Grade: %s%n", 
                subject.getName(), subject.getMarks(), grade);
        }
        
        // Create another student to demonstrate object instances
        Student alice = new Student("Alice Johnson", "S002");
        alice.addSubject(new Subject("Mathematics", 95.0));
        alice.addSubject(new Subject("Science", 90.0));
        alice.addSubject(new Subject("English", 87.0));
        
        calculator.generateResult(alice);
    }
}
