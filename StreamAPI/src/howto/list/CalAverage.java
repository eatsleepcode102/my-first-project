package howto.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalAverage {

	public static void main(String[] args) {
		// we would like to know how to calculate average age for Person List
		List<Person> persons =
		        Arrays.asList(
		            new Person("Max", 18),
		            new Person("Peter", 23),
		            new Person("Pamela", 23),
		            new Person("David", 12));   

		Double avergeAge=persons.stream().collect(Collectors.averagingInt(p->p.age));
		System.out.println(avergeAge);
	}
}
class Person {
	  String name;
	  int age;

	  Person(String name, int age) {
	      this.name = name;
	      this.age = age;
	  }

	  @Override
	  public String toString() {
	      return name;
	  }
	}