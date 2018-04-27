package howto.lambdaapi;

import java.util.*;
import java.util.function.Predicate;

public class AndPredicate {

	public static void main(String[] args) {
		
		//negate
		Predicate<String> isEmpty=String::isEmpty;
		System.out.println("Test using nagate: "+ isEmpty.test("") +"negate:"+ isEmpty.test("sdf"));
		
		
		Predicate<Student1> isPaidEnough = e -> e.gpa > 1;
		Predicate<Student1> isExperiencedEnough = e -> e.id < 10;

		List<Student1> students = Arrays.asList(
				new Student1(1, 0, "John"), 
				new Student1(2, 4, "Jane"),
				new Student1(3, 3, "Jack")
				);
		System.out.println(findStudents(students, isPaidEnough));
		System.out.println(findStudents(students, isExperiencedEnough));
		System.out.println(findStudents(students, isExperiencedEnough.and(isPaidEnough)));
		Student1 somebody = students.get(0);
	    System.out.println(findStudents(students, Predicate.<Student1>isEqual(somebody)));
	}

	public static List<Student1> findStudents(List<Student1> employees, Predicate<Student1> condition) {
		List<Student1> result = new ArrayList<>();
		for (Student1 e : employees) {
			if (condition.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
}

class Student1 {
	public int id;
	public long gpa;
	public String name;

	Student1(int id, long g, String name) {
		this.id = id;
		this.gpa = g;
		this.name = name;
	}

	@Override
	public String toString() {
		return id + ">" + name + ": " + gpa;
	}
}