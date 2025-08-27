package problem_02;

public class age_cal  {
    public static void main(String[] args) {
        int birthYear = 2000;
        int currentYear = 2024;

        int age = currentYear - birthYear;

        System.out.println("Harry's age in " + currentYear + " is " + age);
    }

    public static class average_pcm {
        public static void main(String[] args) {

            double mathsMark = 94;
            double physicsMark = 95;
            double chemistryMark = 96;

            double maxMarksPerSubject = 100;

            double totalMarksObtained = mathsMark + physicsMark + chemistryMark;
            double totalMaxMarks = maxMarksPerSubject * 3;

            double averagePercentage = (totalMarksObtained / totalMaxMarks) * 100;

            System.out.println("Sam’s average mark in PCM is " + averagePercentage);
        }
    }
}
