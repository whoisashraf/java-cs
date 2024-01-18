
public class Employee {
    String name;
    int age;
    String department;
    int salary;

    public Employee(String name, int age, String department, int salary){
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }
    
}