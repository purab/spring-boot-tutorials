import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class EmployeeDatabase {

    public static List<Employee> getEmployees() {
        return Stream.of(new Employee(101,"purab","A", (double) 5422888),
                new Employee(102,"purab01","B", (double) 53388),
        new Employee(103,"purab3","C", (double) 5328),
        new Employee(104,"purab4","D", (double) 54548),
        new Employee(105,"purab5","A", (double) 58748),
        new Employee(106,"purab6","F", (double) 51238))
        .collect(Collectors.toList());
    }
}
