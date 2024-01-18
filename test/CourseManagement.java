
import java.util.ArrayList;

class CourseManagement {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();

    public static void addCourse(String courseCode, String courseName, int maxCapacity, int credits) {
        // Check if a course with the same code already exists
        boolean courseExists = false;
        for (Course existingCourse : courses) {
            if (existingCourse.getCourseCode().equals(courseCode)) {
                courseExists = true;
                break;
            }
        }

        if (courseExists) {
            System.out.println("Error: Course with the same code already exists.");
        } else {
            Course newCourse = new Course(courseCode, courseName, maxCapacity, credits);
            courses.add(newCourse);
            System.out.println("Course added successfully!");
        }
    }

    public static void enrollStudent(Student student, Course course) {
        if (course.getMaxCapacity() > course.getEnrolledStudents().size()) {
            student.enrollInCourse(course);
            course.enrollStudent(student); // Add the student to the course
            students.add(student); // Add the student to the list
        } else {
            System.out.println("Error: Course has reached maximum capacity.");
        }
    }

    public static void assignGrade(Student student, Course course, int grade) {
        student.assignGrade(course, grade);
    }

    public static void clearCoursesAndStudents() {
        courses.clear();
        students.clear();
    }

    public static double calculateOverallGrade(Student student) {
        int totalCredits = 0;
        int totalWeightedGrades = 0;

        for (Course course : student.getEnrolledCourses()) {
            System.out.println("Course: " + course.getCourseCode() + ", Grade: " + course.getGrade() + ", Credits: "
                    + course.getCredits());
            if (course.getGrade() != -1) {
                totalWeightedGrades += course.getGrade() * course.getCredits();
                totalCredits += course.getCredits();
            }
        }

        System.out.println("Total Weighted Grades: " + totalWeightedGrades);
        System.out.println("Total Credits: " + totalCredits);

        return totalCredits != 0 ? (double) totalWeightedGrades / totalCredits : 0.0;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static Course getCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
