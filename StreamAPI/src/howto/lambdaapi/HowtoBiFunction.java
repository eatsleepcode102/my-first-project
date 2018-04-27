package howto.lambdaapi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class HowtoBiFunction {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("John", 20_000), new Employee("Max", 45_000),
				new Employee("Jane", 11_000));
		BiFunction<Employee, Double, Double> raiser = (e, increase) 
				-> e.salary + ((e.salary < 30_000) ? (e.salary * increase / 100) : 0);
		System.out.println(bimapIt(employees, 10D, raiser));
	}

	public static Map<String, Double> bimapIt(List<Employee> candidates, Double raise,
			BiFunction<Employee, Double, Double> mapper) {
		Map<String, Double> applied = new HashMap<>();
		for (Employee cadidate : candidates) {
			applied.put(cadidate.name, mapper.apply(cadidate, raise));
		}
		return applied;
	}
}

class Employee {
	public String name;
	public double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
}