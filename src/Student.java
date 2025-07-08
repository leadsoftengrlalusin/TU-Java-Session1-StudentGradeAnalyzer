/**
 * Final Submission, TU-Java-Session1-StudentGradeAnalyzer
 */

class Student {
    private String name;
    private int score;
    private char grade;

    public Student(String name, int score, char grade) {
        this.name = name;
        this.score = score;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public char getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Score: " + score + ", Grade: " + grade;
    }
}