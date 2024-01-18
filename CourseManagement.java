// CourseManagement.java

import java.util.ArrayList;

public class CourseManagement {
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<String> courseCodes = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();

    public void addCourse(Course course, String courseCode) {
        var index = courses.indexOf(course);
        courses.add(course);
        courseCodes.set(index, courseCode);
    }

    public void removeCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
        }
    }

    public void assignGrade(Student student, Course course, int grade) {
        student.assignGrade(course, grade);
    }

    public int calculateOverallGrade(Student student) {
        return student.overallGrades();
    }

    public void enrollStudent(Student student, Course course) {
        student.enrollStudent(student, course);
    }
}
