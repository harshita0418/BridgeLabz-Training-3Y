public class SamPCMAverageMarks {
    public static void main(String[] args) {
        String studentName = "Sam";
        int mathsMarks = 94;
        int physicsMarks = 95;
        int chemistryMarks = 96;
        int totalSubjects = 3;
        
        int totalMarks = mathsMarks + physicsMarks + chemistryMarks;
        double averageMarks = (double) totalMarks / totalSubjects;
        
        System.out.println(studentName + "'s average mark in PCM is " + averageMarks);
    }
}
