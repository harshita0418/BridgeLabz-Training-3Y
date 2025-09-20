class StudentGradeSystem {
    private int numberOfStudents;
    private int[][] scores;
    
    public StudentGradeSystem(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        this.scores = new int[numberOfStudents][3];
        generateRandomScores();
    }
    
    private void generateRandomScores() {
        for (int i = 0; i < numberOfStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int) (Math.random() * 91) + 10;
            }
        }
    }
    
    public double[][] calculateTotalAveragePercentage() {
        double[][] results = new double[numberOfStudents][3];
        for (int i = 0; i < numberOfStudents; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3;
            double percentage = total / 3;
            results[i][0] = Math.round(total * 100.0) / 100.0;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }
    
    public void displayScorecard() {
        double[][] results = calculateTotalAveragePercentage();
        
        System.out.println("Student Scorecard");
        System.out.println("Student#\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.printf("%d\t\t%d\t%d\t\t%d\t%.0f\t%.2f\t%.2f%%\n",
                i+1, scores[i][0], scores[i][1], scores[i][2],
                results[i][0], results[i][1], results[i][2]);
        }
    }
}

public class StudentScorecard {
    public static void main(String[] args) {
        StudentGradeSystem gradeSystem = new StudentGradeSystem(5);
        gradeSystem.displayScorecard();
    }
}
