import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    int studentCount() {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        return myObj.nextInt();
    }

    ArrayList<Student> studentData(int count) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < count; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");

            String name = scanner.nextLine();

            System.out.printf("Enter Score for %s: ", name);
            int score = scanner.nextInt();

            char grade = setGrade(score);

            System.out.printf("%s got grade %s\n", name, grade);

            scanner.nextLine();

            Student student = new Student(name, score, grade);
            studentList.add(student);
        }

        return studentList;
    }

    char setGrade(int score) {
        switch(score / 10) {
            case 10:
            case 9:
                return 'A';
            case 8:
                return 'B';
            case 7:
                return 'C';
            case 6:
                return 'D';
            default:
                return 'F';
        }
    }

    int getTopScore(ArrayList<Student> studentList) {
        int topScore = Integer.MIN_VALUE;
        for (Student student : studentList) {
            if (student.getScore() > topScore) {
                topScore = student.getScore();
            }
        }
        return topScore;
    }

    ArrayList<Student> getTopStudents(ArrayList<Student> studentList, int topScore) {
        ArrayList<Student> topStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getScore() == topScore) {
                topStudents.add(student);
            }
        }
        return topStudents;
    }

    void printStudentData(ArrayList<Student> studentList) {
        System.out.println("\n----- Class Summary -----");

        // Compute average
        int totalScore = 0;
        for (Student student : studentList) {
            totalScore += student.getScore();
        }
        double average = (double) totalScore / studentList.size();
        System.out.printf("Average Score: %.2f\n", average);

        // Count grades
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        for (Student student : studentList) {
            switch (student.getGrade()) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
                case 'F': countF++; break;
            }
        }

        System.out.printf("Grade Counts: A:%d B:%d C:%d D:%d F:%d\n", countA, countB, countC, countD, countF);

        int topScore = getTopScore(studentList);
        ArrayList<Student> topStudents = getTopStudents(studentList, topScore);

        System.out.print("Top Student(s): ");
        for (int i = 0; i < topStudents.size(); i++) {
            Student s = topStudents.get(i);
            System.out.printf("%s (%d)", s.getName(), s.getScore());
            if (i != topStudents.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main main = new Main();
        int count = main.studentCount();
        ArrayList<Student> studentData = main.studentData(count);
        main.printStudentData(studentData);
    }

}
