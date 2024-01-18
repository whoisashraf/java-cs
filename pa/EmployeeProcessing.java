import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeProcessing {
    public static void main(String[] args) {
        // sample dataset
        List<Employee> employees = Arrays.asList(
                new Employee("John", 35, "IT", 75000),
                new Employee("Alice", 28, "HR", 60000),
                new Employee("Sarah", 31, "Compliance", 100000),
                new Employee("Bob", 40, "Finance", 85000));

        // Function to concatenate employee name and department
        Function<Employee, String> nameDeptConcatenator = employee -> employee.name + " - " + employee.department;

        // Using streams to generate a new collection of concatenated strings
        List<String> concatenatedList = employees.stream().map(nameDeptConcatenator).collect(Collectors.toList());

        // Print the concatenated list
        System.out.println("Concatenated Strings:");
        concatenatedList.forEach(System.out::println);

        // Calculate the average salary using streams
        double averageSalary = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);

        System.out.println("\nAverage Salary of Employees: " + averageSalary);

        // Filter employees based on age threshold (e.g., 30)
        int ageThreshold = 30;
        List<Employee> filteredEmployees = employees.stream().filter(employee -> employee.age > ageThreshold)
                .collect(Collectors.toList());

        // Print filtered employees
        System.out.println("\nEmployees above " + ageThreshold + " years old:");
        filteredEmployees.forEach(employee -> System.out.println(employee.name));
    }
}
