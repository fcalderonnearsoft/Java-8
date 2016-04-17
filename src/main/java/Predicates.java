import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by fcalderon on 4/16/16.
 */
public class Predicates {
    public static void main(String args[]) {
        Predicate<Employee> isRich = e -> e.getSalary() > 20000;
        Predicate<Employee> isEarly = e -> e.getId() <= 10;

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Fer", 3, 30000));
        employees.add(new Employee("Leo", 400, 30000));
        employees.add(new Employee("Gera", 2000, 30));
        employees.add(new Employee("Jorge", 3, 9));
        employees.add(new Employee("Erick", 355, 45));

        System.out.printf("Rich employees: %s.%n", allMatches(employees, isRich));
        System.out.printf("Employees hired early: %s.%n", allMatches(employees, isEarly));
        System.out.printf("Employees that are rich AND hired early: %s.%n",
                allMatches(employees, isRich.and(isEarly)));
        System.out.printf("Employees that are rich OR hired early: %s.%n",
                allMatches(employees, isRich.or(isEarly)));
        System.out.printf("Employees that are NOT rich: %s.%n",
                allMatches(employees, isRich.negate()));
        Employee polly = employees.get(1);
        Predicate<Employee> isPolly = Predicate.isEqual(polly);
        System.out.printf("Employees in list that are equals to Polly Programmer: %s.%n",
                allMatches(employees, isPolly));

    }

    public static <T extends Employee> List<String> allMatches(List<T> candidates, Predicate<T> matchFunction) {
        List<String> matches = new ArrayList<>();
        for (T possibleMatch : candidates){
            if(matchFunction.test(possibleMatch))
                matches.add(possibleMatch.getName());
        }
        return matches;
    }
}
class Employee {
    private String _name;
    private int _id;
    private long _salary;

    public Employee(String name, int id, long salary) {
        _id = id;
        _name = name;
        _salary = salary;
    }

    public String getName() {
        return _name;
    }

    public int getId() {
        return _id;
    }

    public long getSalary() {
        return _salary;
    }
}
