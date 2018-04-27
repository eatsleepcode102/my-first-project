package howto.lambdaapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerCalculation {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("John", 22_000), new Employee("Mark", 11_000));
		acceptAllEmployee(employees, e -> System.out.println(e.name));
		acceptAllEmployee(employees, e -> e.salary *= 1.5);
		acceptAllEmployee(employees, e -> System.out.println(e.name + ": " + e.salary));

	}

	public static void acceptAllEmployee(List<Employee> employees, Consumer<Employee> printer) {
		for (Employee e : employees) {
			printer.accept(e);
		}
	}
}

//class Employee {
//	public String name;
//	public double salary;
//
//	Employee(String name, double salary) {
//		this.name = name;
//		this.salary = salary;
//	}
//}