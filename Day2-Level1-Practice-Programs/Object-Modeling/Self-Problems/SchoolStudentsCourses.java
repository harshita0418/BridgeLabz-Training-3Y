import java.util.*;

class Course {
    private String courseId;
    private String courseName;
    private ArrayList<Student> enrolledStudents;
    
    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }
    
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }
    
    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : enrolledStudents) {
            System.out.println("  - " + student.getName());
        }
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public String getCourseId() {
        return courseId;
    }
}

class Student {
    private String studentId;
    private String name;
    private ArrayList<Course> enrolledCourses;
    
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }
    
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this);
    }
    
    public void viewEnrolledCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course course : enrolledCourses) {
            System.out.println("  - " + course.getCourseName());
        }
    }
    
    public String getName() {
        return name;
    }
    
    public String getStudentId() {
        return studentId;
    }
}

class School {
    private String schoolName;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }
    
    public void addStudent(Student student) {
