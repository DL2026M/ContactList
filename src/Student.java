public class Student extends Person {
    // Instance Variable
    private int grade;

    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        // Calling the superclass
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
    public String toString() {
        return super.toString() + " Grade: " + this.grade;
    }
}
