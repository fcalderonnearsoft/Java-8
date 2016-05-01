import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by fcalderon on 4/30/16.
 */
public class Streams {
    static List<Employee> employees = new ArrayList<>();
    public static void main(String args[])
    {
        String[] array = {"hello", "from", "streams", "in", "java 8"};
        Stream.of(array).forEach(System.out::println);

        setEmployees();


        employees.stream().forEach(e -> e.setSalary(e.getSalary() * 11/10));
        employees.stream().forEach(e -> System.out.println(e.getSalary()));

        employees.stream().filter(e -> e.getSalary() > 20000).forEach(System.out::println);
        employees.stream().filter(e -> e.getId() <= 10).forEach(System.out::println);

    }
    public static void setEmployees(){
        employees.add(new Employee("Fer", 3, 30000));
        employees.add(new Employee("Leo", 400, 30000));
        employees.add(new Employee("Gera", 2000, 30));
        employees.add(new Employee("Jorge", 3, 9));
        employees.add(new Employee("Erick", 355, 45));
    }


}

