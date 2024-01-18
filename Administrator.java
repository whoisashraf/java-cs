import java.util.Scanner;

public class Administrator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseManagement courseManagement = new CourseManagement();
        int choice;
        do {
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. Assign Grade");
            System.out.println("4. Calculate Overall Grade");
            System.out.println("5. Enroll Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter course name: ");
                    String courseName = scanner.next();
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.next();
                    Course course = new Course(courseName, courseCode);
                    courseManagement.addCourse(course, courseCode);
                    break;
                case 2:
                    System.out.print("Enter course code to remove: ");
                    String codeToRemove = scanner.next();
                    courseManagement.removeCourse(course);
                    break;
                case 3:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.next();
                    System.out.print("Enter course name: ");
                    String courseToGrade = scanner.next();
                    System.out.print("Enter grade: ");
                    Course studentCourse;
                    int grade = scanner.nextInt();
                    if (courseManagement.courses.contains(courseToGrade)) {
                        var index = courseManagement.courses.indexOf(courseToGrade);
                        studentCourse = courseManagement.courses.get(index);
                    }
                    if (courseManagement.students.contains(studentName)) {
                        var index = courseManagement.students.indexOf(studentName);
                        var student = courseManagement.students.get(index);
                        courseManagement.assignGrade(student,studentCourse,grade);
                    }
                    
                    break;
                case 4:
                    System.out.print("Enter student name: ");
                    var studentToSearch = scanner.next();
                    Student studentForOverallGrade;
                    if (courseManagement.students.contains(studentToSearch)) {
                        var index = courseManagement.students.indexOf(studentToSearch);
                        var student = courseManagement.students.get(index);
                        studentForOverallGrade = student;
                    }
                    int overallGrade = courseManagement.calculateOverallGrade(studentForOverallGrade);
                    System.out.println("Overall Grade: " + overallGrade);
                    break;
                case 5:
                    System.out.print("Enter student name:");
                    String student_name = scanner.next();
                    Student student = new Student(student_name);
                    System.out.print("Enter course name: ");
                    String courseToEnroll = scanner.next();
                    if (courseManagement.courses.contains(courseToEnroll)) {
                        var index = courseManagement.courses.indexOf(courseToEnroll);
                        var student_course = courseManagement.courses.get(index);
                        courseManagement.enrollStudent(student, student_course);
                    } else {
                        System.out.println("Course not offered here, sorry.");
                    }
                    break;
                default:
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }
}
