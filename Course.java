// Course.java

public class Course {
    public static int totalInstances = 0;
    private String courseCode;
    private String courseName;
    private int maximumCapacity = 30;
    // private int grade;

    Course(String name, String code, int capacity){
        courseCode = code;
        courseName = name;
        maximumCapacity = capacity;
        totalInstances = totalInstances + 1;
    }

    Course(String name, String code){
        courseCode = code;
        courseName = name;
        // maximumCapacity = capacity;
        totalInstances = totalInstances + 1;
    }

    public String gerCurseName(){
        return courseName;
    }
}