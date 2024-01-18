import java.util.Scanner;

public class pa3 {

    // Instance variables for student attributes
    public static class Student {
        private String name;
        private int id;
        private int age;
        private float grade;

        // Constructor to initialize student attributes
        public Student(String name, int id, int age, float grade) {
            this.name = name;
            this.id = id;
            this.age = age;
            this.grade = grade;
        }

        // Methods for accessing private attributes
        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        public float getGrade() {
            return grade;
        }

        // Methods for updating attributes
        public void updateName(String name) {
            this.name = name;
        }

        public void updateAge(int age) {
            this.age = age;
        }

        public void updateGrade(float grade) {
            this.grade = grade;
        }

        // Override toString method for a formatted string representation                                                               
        @Override
        public String toString() {
            return "Name: " + name + "\n" +
                    "ID: " + id + "\n" +
                    "Age: " + age + "\n" +
                    "Grade: " + grade + "\n";
        }
    }

    public static class StudentManagement {

        // Constructor to initialize the array with a given size
        public StudentManagement(int size) {
            this.students = new Student[size];
        }

        // Instance variable for an array of Student objects
        private Student[] students;

        // Method to get the total number of students in the array
        public int getStudentTotal() {
            int count = 0;
            for (var val : students) {
                if (val != null) {
                    count++;
                }
            }
            return count;
        }

        // Method to get a specific student by index in the array
        public Student getStudent(int num) {
            return students[num];
        }

        // Method to add a new student to the array
        public void addStudent(Student student) {
            students[student.getId()] = student;
        }
    }

    public static void main(String[] args) {
        // Scanner initialization to accept user input
        Scanner scan = new Scanner(System.in);
        // StudentManagement initialization with fixed array size of 100
        StudentManagement management = new StudentManagement(100);
        // Variable to create student id
        int nextId = 0;

        // Administrator Interface
        boolean exit = false;
        while (!exit) {
            // Display menu options
            System.out.println("University Record Management System\n");
            System.out.println("1. Add a new student");
            System.out.println("2. Update student information");
            System.out.println("3. View student details");
            System.out.println("4. Exit\n");
            System.out.print("Enter your choice: ");

            // Get user input for menu selection
            int command = scan.nextInt();
            switch (command) {
                case 1:
                    // Code to add a new student
                    // Prompt user for student name
                    System.out.print("Enter student name: ");
                    String name = scan.next();

                    // Prompt user for student age until a valid input is submitted
                    int age = 0;
                    boolean validAgeInput = false;
                    while (!validAgeInput) {
                        System.out.print("Enter student age: ");
                        try {
                            age = scan.nextInt();
                            validAgeInput = true;
                        } catch (Exception e) {
                            System.out.println("Input must be a number");
                            scan.nextLine();
                        }
                    }

                    // Prompt user for student grade until a valid input is submitted
                    int grade = 0;
                    boolean validGradeInput = false;
                    while (!validGradeInput) {
                        System.out.print("Enter student grade: ");
                        try {
                            grade = scan.nextInt();
                            validGradeInput = true;
                        } catch (Exception e) {
                            System.out.println("Input must be a number");
                            scan.nextLine();
                        }
                    }
                    // Icrement default by 1
                    nextId += 1;
                    // Create a new student
                    Student student = new Student(name, nextId, age, grade);
                    // Attempt to add new student to the students array
                    try {
                        // Add student to array
                        management.addStudent(student);
                        System.out.print("\n");
                        System.out.println("Student added successfully, " + "ID: " + nextId + "\n");
                    } catch (Exception e) {
                        // Print error message
                        System.out.println("Failed to add student");
                    }
                    break;
                case 2:
                    // Code to update student information
                    // Prompt user for id
                    System.out.println("Enter student ID: ");
                    int updateId = scan.nextInt();
                    // Get student by id
                    Student studentToUpdate = management.getStudent(updateId);

                    if (studentToUpdate == null) {
                        System.out.println("Student doesn't exist");
                        System.out.println("Please ensure you supplied the correct ID\n");
                    } else {
                        System.out.print("");
                        System.out.println(
                                "Current information for student with ID " + updateId + ":\n" + studentToUpdate);
                        System.out.println("Enter new information:");

                        System.out.print("Enter student name: ");
                        String newName = scan.next();

                        // Prompt user for student age until a valid input is submitted
                        int newAge = 0;
                        boolean validNewAgeInput = false;
                        while (!validNewAgeInput) {
                            System.out.print("Enter student age: ");
                            try {
                                newAge = scan.nextInt();
                                validNewAgeInput = true;
                            } catch (Exception e) {
                                System.out.println("Input must be a number");
                                scan.nextLine();
                            }
                        }

                        // Prompt user for student grade until a valid input is submitted
                        float newGrade = 0;
                        boolean validNewGradeInput = false;
                        while (!validNewGradeInput) {
                            System.out.print("Enter student grade: ");
                            try {
                                newGrade = scan.nextFloat();
                                validNewGradeInput = true;
                            } catch (Exception e) {
                                System.out.println("Input must be a number");
                                scan.nextLine();
                            }
                        }

                        // Update srudent information
                        studentToUpdate.updateName(newName);
                        studentToUpdate.updateAge(newAge);
                        studentToUpdate.updateGrade(newGrade);

                        // Print success message
                        System.out.print("");
                        System.out.println("Student information updated successfully.\n");
                    }
                    break;
                case 3:
                    // Code to view student details
                    // Prompt user for student id
                    System.out.println("Enter student ID to view details: ");
                    int id = scan.nextInt();
                    // Get student by id
                    Student student_to_find = management.getStudent(id);
                    if (student_to_find == null) {
                        System.out.println("Student doesn't exist");
                        System.out.println("Please ensure you supplied the correct ID\n");
                    } else {
                        // Print information about requested student with the overridden tostring method
                        System.out.println(student_to_find);
                    }
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Exiting gracefully...");
                    exit = true;
                    break;
                default:
                    // Handle invalid input
                    System.out.println("Invalid! Try numbers 1 - 4");
                    break;
            }

        }

        // Close the scanner
        scan.close();
    }
}
