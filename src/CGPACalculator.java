import java.util.Scanner;

public class CGPACalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define courses and points for grades
        String[] courses = {"Maths", "English", "Computer Science", "Physics", "Chemistry"};
        double[] scores = new double[courses.length];
        double[] points = new double[courses.length];
        String[] grades = new String[courses.length];
        boolean[] validScores = new boolean[courses.length];

        // Input scores for each course
        for (int i = 0; i < courses.length; i++) {
            while (true) {
                System.out.print("Enter score for " + courses[i] + " (0-100): ");
                scores[i] = scanner.nextDouble();

                if (scores[i] >= 0 && scores[i] <= 100) {
                    validScores[i] = true;
                    break;
                } else {
                    System.out.println("Invalid score for " + courses[i] + ". Please enter a score between 0 and 100.");
                    System.out.print("Do you want to re-enter a valid score? (Yes/No): ");
                    String response = scanner.next();

                    if (response.equalsIgnoreCase("Yes")) {
                        continue;
                    } else {
                        validScores[i] = false;
                        scores[i] = -1; // Flag for invalid score
                        break;
                    }
                }
            }
        }

        // Calculate points and grades for each course
        for (int i = 0; i < courses.length; i++) {
            if (validScores[i]) {
                if (scores[i] >= 70 && scores[i] <= 100) {
                    points[i] = 5;
                    grades[i] = "A";
                } else if (scores[i] >= 60 && scores[i] < 70) {
                    points[i] = 4;
                    grades[i] = "B";
                } else if (scores[i] >= 50 && scores[i] < 60) {
                    points[i] = 3;
                    grades[i] = "C";
                } else if (scores[i] >= 45 && scores[i] < 50) {
                    points[i] = 2;
                    grades[i] = "D";
                } else if (scores[i] >= 40 && scores[i] < 45) {
                    points[i] = 1;
                    grades[i] = "E";
                } else if (scores[i] < 40) {
                    points[i] = 0;
                    grades[i] = "F";
                }
            } else {
                points[i] = -1; // Flag for invalid score
                grades[i] = "-"; // Flag for invalid grade
            }
        }

        // Calculate CGPA
        double sumPoints = 0;
        int countValidScores = 0;
        for (int i = 0; i < courses.length; i++) {
            if (validScores[i]) {
                sumPoints += points[i];
                countValidScores++;
            }
        }

        double cgpa;
        if (countValidScores == 0) {
            cgpa = 0;
            System.out.println("No valid scores to calculate CGPA.");
        } else {
            cgpa = sumPoints / countValidScores;
        }

        // Display results
        System.out.println("\nCourse\tScore\tPoint\tGrade");
        for (int i = 0; i < courses.length; i++) {
            if (validScores[i]) {
                System.out.println(courses[i] + "\t" + scores[i] + "\t" + points[i] + "\t" + grades[i]);
            } else {
                System.out.println(courses[i] + "\tInvalid\t-\t-");
            }
        }
        System.out.println("\nCGPA: " + cgpa);

        System.out.println("\nPlease consult the authorities should there be any complaints");
    }
}

