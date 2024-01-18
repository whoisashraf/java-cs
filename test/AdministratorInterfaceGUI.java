import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdministratorInterfaceGUI extends JFrame {

    private final JButton addCourseButton;
    private final JButton enrollStudentsButton;
    private final JButton assignGradesButton;
    private final JButton calculateOverallGradesButton;
    private final JButton exitButton;

    public AdministratorInterfaceGUI() {
        super("Administrator Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame

        JPanel panel = new JPanel(new GridLayout(5, 1));

        addCourseButton = new JButton("Add a new course");
        enrollStudentsButton = new JButton("Enroll students");
        assignGradesButton = new JButton("Assign grades");
        calculateOverallGradesButton = new JButton("Calculate overall course grades");
        exitButton = new JButton("Exit");

        addCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNewCourse();
            }
        });

        enrollStudentsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enrollStudents();
            }
        });

        assignGradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assignGrades();
            }
        });

        calculateOverallGradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateOverallCourseGrades();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitProgram();
            }
        });

        panel.add(addCourseButton);
        panel.add(enrollStudentsButton);
        panel.add(assignGradesButton);
        panel.add(calculateOverallGradesButton);
        panel.add(exitButton);

        getContentPane().add(panel);
    }

    private void addNewCourse() {
        String courseCode = JOptionPane.showInputDialog(this, "Enter course code:");
        String courseName = JOptionPane.showInputDialog(this, "Enter course name:");
        int maxCapacity = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter max capacity:"));
        int credits = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter credits:"));

        CourseManagement.addCourse(courseCode, courseName, maxCapacity, credits);
        JOptionPane.showMessageDialog(this, "New course added successfully!");
    }

    private void enrollStudents() {
        String studentName = JOptionPane.showInputDialog(this, "Enter student name:");
        int studentId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter student ID:"));

        Student student = new Student(studentName, studentId);

        String enrollCourseCode = JOptionPane.showInputDialog(this, "Enter course code to enroll in:");
        Course enrollCourse = CourseManagement.getCourseByCode(enrollCourseCode);

        if (enrollCourse != null) {
            CourseManagement.enrollStudent(student, enrollCourse);
            JOptionPane.showMessageDialog(this, "Student enrolled successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Error: Course not found.");
        }
    }

    private void assignGrades() {
        ArrayList<Student> studentsList = CourseManagement.getStudents();
        int assignGradeStudentId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter student ID:"));
        String assignGradeCourseCode = JOptionPane.showInputDialog(this, "Enter course code:");
        int assignGrade = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter grade:"));

        Student assignGradeStudent = findStudentById(studentsList, assignGradeStudentId);
        Course assignGradeCourse = CourseManagement.getCourseByCode(assignGradeCourseCode);

        if (assignGradeStudent != null && assignGradeCourse != null) {
            CourseManagement.assignGrade(assignGradeStudent, assignGradeCourse, assignGrade);
            JOptionPane.showMessageDialog(this, "Grade assigned successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Error: Student or course not found.");
        }
    }

    private void calculateOverallCourseGrades() {
        ArrayList<Student> studentsListOverall = CourseManagement.getStudents();
        int calculateOverallGradeStudentId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter student ID:"));

        Student calculateOverallGradeStudent = findStudentById(studentsListOverall, calculateOverallGradeStudentId);

        if (calculateOverallGradeStudent != null) {
            double overallGrade = CourseManagement.calculateOverallGrade(calculateOverallGradeStudent);
            JOptionPane.showMessageDialog(this, "Overall Grade: " + overallGrade);
        } else {
            JOptionPane.showMessageDialog(this, "Error: Student not found.");
        }
    }

    private void exitProgram() {
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            CourseManagement.clearCoursesAndStudents();
            System.exit(0);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdministratorInterfaceGUI().setVisible(true);
            }
        });
    }
}
