
import java.util.ArrayList;

class Course {
    private String courseCode;
    private String name;
    private int maxCapacity;
    private int credits;
    private int grade = -1; // Default value to indicate an ungraded course
    private ArrayList<Student> enrolledStudents = new ArrayList<>();

    public Course(String courseCode, String name, int maxCapacity, int credits) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCredits() {
        return credits;
    }

    public int getGrade() {
        return grade;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
