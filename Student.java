// Student.java

import java.util.ArrayList;

public class Student {
    private String name;
    public static int makeId = 0;
    private int id;
    private ArrayList<Course> enrolledCourses = new ArrayList<>();
    private ArrayList<Integer> grades = new ArrayList<>();


    Student(String name) {
        this.name = name;
        makeId = makeId + 1;
        this.id = makeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Course> getCourses() {
        return enrolledCourses;
    }

    public void removeCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            enrolledCourses.remove(course);
        }
    }

    public void assignGrade(Course course, int grade) {
        if(enrolledCourses.contains(course)){
            var index = enrolledCourses.indexOf(course);
            grades.set(index,grade);
        }
    }

    public void enrollStudent(Student student, Course course) {
        enrolledCourses.add(course);
    }

    public int overallGrades(){
        var sum = 0;
        for(var grade : grades){
            sum = sum + grade;
        }
        return sum;
    }
}

