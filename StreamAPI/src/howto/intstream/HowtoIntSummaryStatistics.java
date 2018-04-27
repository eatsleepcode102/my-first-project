package howto.intstream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HowtoIntSummaryStatistics {

	public static void main(String[] args) {
		
		//get average in a specific range
		IntStream.range(0, 10).average().ifPresent(System.out::println);
		
		
		List<Person> persons =
		        Arrays.asList(
		                new Person("Max", 18),
		                new Person("Peter", 23),
		                new Person("Pamela", 23),
		                new Person("David", 12));   
		IntSummaryStatistics agesSummary=persons.stream().collect(Collectors.summarizingInt(p->p.age));
		System.out.println(agesSummary);
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