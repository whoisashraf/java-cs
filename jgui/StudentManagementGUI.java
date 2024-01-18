/**
 * StudentManagementGUI - A GUI application for Student Management System.
 * This application allows administrators to manage student records, course enrollment, and grades.
 *
 * Components:
 * - Add Student: Adds a new student to the system.
 * - Update Student: Updates existing student information.
 * - View Student Details: Displays a list of students and their details.
 * - Enroll Students: Enrolls students in selected courses.
 * - Assign Grades: Assigns grades to students in selected courses.
 *
 * Usage:
 * 1. Click "Add Student" to add a new student. Enter student information in the prompted form.
 * 2. Click "Update Student" to update an existing student's information. Select a student and modify the details.
 * 3. Click "View Student Details" to view a list of all students and their information.
 * 4. Click "Enroll Students" to enroll students in courses. Select a student and a course for enrollment.
 * 5. Click "Assign Grades" to assign grades to students. Select a student, a course, and provide the grade.
 *
 * Dynamic Interface Updates:
 * - The interface updates in real-time to reflect changes in student records, course enrollment, and grades.
 *
 * Error Handling:
 * - The application displays error messages for invalid inputs or exceptional situations.
 *
 * Author: [Your Name]
 * Date: [Current Date]
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class StudentManagementGUI extends JFrame {

    private HashMap<String, Student> students;
    private HashMap<String, Course> courses;
    private HashMap<String, EnrolledStudent> enrolledStudents;
    private HashMap<String, Integer> grades;

    private JComboBox<String> studentComboBox;
    private JComboBox<String> courseComboBox;
    private JComboBox<String> studentUpdateComboBox;
    private JTextField updatedNameField;
    private JButton updateStudentButton;
    private JButton viewStudentDetailsButton;
    private JButton enrollStudentsButton;
    private JButton assignGradesButton;
    

    public StudentManagementGUI() {
        students = new HashMap<>();
        courses = new HashMap<>();
        enrolledStudents = new HashMap<>();
        grades = new HashMap<>();

        initializeUI();
        createComponents();
        setupEventHandlers();
        // createComponents();  // Update the existing createComponents method
        // setupEventHandlers();
    }

    private void initializeUI() {
        setTitle("Student Management System");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));
    }

    private void createComponents() {
        // Add a student
        JLabel studentLabel = new JLabel("Select Student:");
        add(studentLabel);

        studentComboBox = new JComboBox<>();
        add(studentComboBox);

        JLabel nameLabel = new JLabel("Enter Name:");
        add(nameLabel);

        JTextField nameField = new JTextField();
        add(nameField);

        JButton addStudentButton = new JButton("Add Student");
        add(addStudentButton);

        // Update Student
        JLabel studentUpdateLabel = new JLabel("Select Student to Update:");
        add(studentUpdateLabel);

        studentUpdateComboBox = new JComboBox<>();
        add(studentUpdateComboBox);

        JLabel updatedNameLabel = new JLabel("Enter Updated Name:");
        add(updatedNameLabel);

         // View Student Details
         viewStudentDetailsButton = new JButton("View Student Details");
         add(viewStudentDetailsButton);

        updatedNameField = new JTextField();
        add(updatedNameField);

        updateStudentButton = new JButton("Update Student");
        add(updateStudentButton);

        // Enroll Students
        enrollStudentsButton = new JButton("Enroll Students");
        add(enrollStudentsButton);

        // Assign Grades
        assignGradesButton = new JButton("Assign Grades");
        add(assignGradesButton);

        // Add more components for other functionalities
    }

    private void setupEventHandlers() {
        // Add Student Button Event Handler
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddStudent(nameField.getText());
            }
        });

        // Update Student Button Event Handler
        updateStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleUpdateStudent((String) studentUpdateComboBox.getSelectedItem(), updatedNameField.getText());
            }
        });

        // View Student Details Button Event Handler
        viewStudentDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleViewStudentDetails();
            }
        });

        // Enroll Students Button Event Handler
        enrollStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleEnrollStudents();
            }
        });

         // Assign Grades Button Event Handler
         assignGradesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAssignGrades();
                updateStudentDetails();
            }
        });

        // Add more event handlers for other functionalities
    }

    private void handleAddStudent(String name) {
        // Validate input
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Generate a unique student ID (you might want to implement a proper ID generation method)
        String studentId = "S" + (students.size() + 1);

        // Create a new student
        Student newStudent = new Student(studentId, name);

        // Add the new student to the system
        students.put(studentId, newStudent);

        // Update the student combo box
        updateStudentComboBox();

        // Clear the name field
        nameField.setText("");

        // Show a success message
        JOptionPane.showMessageDialog(this, "Student added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleUpdateStudent(String selectedStudent, String updatedName) {
        // Validate input
        if (selectedStudent == null || updatedName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a student and enter an updated name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Find the selected student
        Student student = students.get(selectedStudent);

        // Update the student's information
        student.setName(updatedName);

        // Update the student combo boxes
        updateStudentComboBox();
        updateStudentUpdateComboBox();

        // Clear the updated name field
        updatedNameField.setText("");

        // Show a success message
        JOptionPane.showMessageDialog(this, "Student information updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleViewStudentDetails() {
        // Validate if there are students to display
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students found.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Prepare details for display
        StringBuilder details = new StringBuilder("Student Details:\n");
        for (Student student : students.values()) {
            details.append("Name: ").append(student.getName()).append(", ID: ").append(student.getId()).append("\n");
        }

        // Display details in a dialog box
        JOptionPane.showMessageDialog(this, details.toString(), "Student Details", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleEnrollStudents() {
        // Validate if there are students and courses to enroll
        if (students.isEmpty() || courses.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students or courses found.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Create arrays for student and course names
        String[] studentNames = students.values().stream().map(Student::getName).toArray(String[]::new);
        String[] courseCodes = courses.values().stream().map(Course::getCourseCode).toArray(String[]::new);

        // Show input dialogs to select student and course
        String selectedStudentName = (String) JOptionPane.showInputDialog(
                this, "Select a student to enroll:", "Enroll Students",
                JOptionPane.QUESTION_MESSAGE, null, studentNames, studentNames[0]);

        String selectedCourseCode = (String) JOptionPane.showInputDialog(
                this, "Select a course to enroll in:", "Enroll Students",
                JOptionPane.QUESTION_MESSAGE, null, courseCodes, courseCodes[0]);

        // Validate selections
        if (selectedStudentName != null && selectedCourseCode != null) {
            // Get student and course objects
            Student selectedStudent = students.get(getStudentIdByName(selectedStudentName));
            Course selectedCourse = courses.get(selectedCourseCode);

            // Enroll student in the course
            selectedCourse.enrollStudent(selectedStudent);
            JOptionPane.showMessageDialog(this, "Student enrolled successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private int getStudentIdByName(String studentName) {
        return students.values().stream()
                .filter(student -> student.getName().equals(studentName))
                .findFirst()
                .map(Student::getId)
                .orElse(-1);
    }

    private void handleAssignGrades() {
        // Validate if there are students and courses to assign grades
        if (students.isEmpty() || courses.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students or courses found.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Create arrays for student and course names
        String[] studentNames = students.values().stream().map(Student::getName).toArray(String[]::new);
        String[] courseCodes = courses.values().stream().map(Course::getCourseCode).toArray(String[]::new);

        // Show input dialogs to select student, course, and grade
        String selectedStudentName = (String) JOptionPane.showInputDialog(
                this, "Select a student to assign grades:", "Assign Grades",
                JOptionPane.QUESTION_MESSAGE, null, studentNames, studentNames[0]);

        String selectedCourseCode = (String) JOptionPane.showInputDialog(
                this, "Select a course to assign grades:", "Assign Grades",
                JOptionPane.QUESTION_MESSAGE, null, courseCodes, courseCodes[0]);

        // Validate selections
        if (selectedStudentName != null && selectedCourseCode != null) {
            // Get student and course objects
            Student selectedStudent = students.get(getStudentIdByName(selectedStudentName));
            Course selectedCourse = courses.get(selectedCourseCode);

            // Show input dialog to enter the grade
            try {
                int grade = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter grade:", "Assign Grades"));
                selectedCourse.assignGrade(selectedStudent, grade);
                JOptionPane.showMessageDialog(this, "Grade assigned successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid grade. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateStudentComboBox() {
        // Update the student combo box dynamically based on the current list of students
        String[] studentNames = students.values().stream().map(Student::getName).toArray(String[]::new);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(studentNames);
        studentComboBox.setModel(model);
    }

    private void updateStudentUpdateComboBox() {
        // Update the student update combo box dynamically based on the current list of students
        String[] studentNames = students.values().stream().map(Student::getName).toArray(String[]::new);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(studentNames);
        studentUpdateComboBox.setModel(model);
    }

    // Update student details method
    private void updateStudentDetails() {
        // ... (previous code to display student details)
        // Ensure that this method updates the display based on the updated data
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentManagementGUI().setVisible(true);
            }
        });
    }
}
