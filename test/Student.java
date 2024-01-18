
import java.util.ArrayList;

class Student {
    private String name;
    private int id;
    private ArrayList<Course> enrolledCourses;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
    }

    public void assignGrade(Course course, int grade) {
        // Find the course in enrolledCourses and assign the grade
        for (Course enrolledCourse : enrolledCourses) {
            if (enrolledCourse.getCourseCode().equals(course.getCourseCode())) {
                enrolledCourse.setGrade(grade);
                break;
            }
        }
    }
}
