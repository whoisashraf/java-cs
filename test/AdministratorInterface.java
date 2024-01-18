
import java.util.Scanner;
import java.util.ArrayList;




public class AdministratorInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        while (true) {
            System.out.println("Administrator Interface");
            System.out.println("1. Add a new course");
            System.out.println("2. Enroll students");
            System.out.println("3. Assign grades");
            System.out.println("4. Calculate overall course grades");
            System.out.println("5. Exit");

            System.out.print("Select an option (1-5): ");

            int option = 0;
            try {
                option = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume the invalid input
                continue;
            }

            switch (option) {
                case 1:
                    addNewCourse(scanner);
                    break;

                case 2:
                    enrollStudents(scanner);
                    break;

                case 3:
                    assignGrades(scanner);
                    break;

                case 4:
                    calculateOverallCourseGrades(scanner);
                    break;

                case 5:
                    System.out.println("Exiting Administrator Interface");
                    // Clear the lists before exiting
                    CourseManagement.clearCoursesAndStudents();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void addNewCourse(Scanner scanner) {
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();
        System.out.print("Enter course name: ");
        scanner.nextLine(); // Consume the newline character
        String courseName = scanner.nextLine();
        System.out.print("Enter max capacity: ");
        int maxCapacity = scanner.nextInt();
        System.out.print("Enter credits: ");
        int credits = scanner.nextInt();

        CourseManagement.addCourse(courseCode, courseName, maxCapacity, credits);
    }

    private static void enrollStudents(Scanner scanner) {
        System.out.print("Enter student name: ");
        String studentName = scanner.next();
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        Student student = new Student(studentName, studentId);

        System.out.print("Enter course code to enroll in: ");
        String enrollCourseCode = scanner.next();
        Course enrollCourse = CourseManagement.getCourseByCode(enrollCourseCode);

        if (enrollCourse != null) {
            CourseManagement.enrollStudent(student, enrollCourse);
            System.out.println("Student enrolled successfully!");
        } else {
            System.out.println("Error: Course not found.");
        }
    }

    private static void assignGrades(Scanner scanner) {
        ArrayList<Student> studentsList = CourseManagement.getStudents();
        System.out.print("Enter student ID: ");
        int assignGradeStudentId = scanner.nextInt();
        System.out.print("Enter course code: ");
        String assignGradeCourseCode = scanner.next();
        System.out.print("Enter grade: ");
        int assignGrade = scanner.nextInt();

        Student assignGradeStudent = findStudentById(studentsList, assignGradeStudentId);
        Course assignGradeCourse = CourseManagement.getCourseByCode(assignGradeCourseCode);

        if (assignGradeStudent != null && assignGradeCourse != null) {
            CourseManagement.assignGrade(assignGradeStudent, assignGradeCourse, assignGrade);
            System.out.println("Grade assigned successfully!");
        } else {
            System.out.println("Error: Student or course not found.");
        }
    }

    private static void calculateOverallCourseGrades(Scanner scanner) {
        ArrayList<Student> studentsListOverall = CourseManagement.getStudents();

        System.out.print("Enter student ID: ");
        int calculateOverallGradeStudentId = scanner.nextInt();

        Student calculateOverallGradeStudent = findStudentById(studentsListOverall, calculateOverallGradeStudentId);

        if (calculateOverallGradeStudent != null) {
            double overallGrade = CourseManagement.calculateOverallGrade(calculateOverallGradeStudent);
            System.out.println("Overall Grade: " + overallGrade);
        } else {
            System.out.println("Error: Student not found.");
        }
    }

    private static Student findStudentById(ArrayList<Student> students, int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }
}
