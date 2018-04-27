package howto.lambdaapi;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

public class Main {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23),
				new Person("David", 12));

		Collector<Person, StringJoiner, String> personNameCollector = Collector.of(() -> {
			System.out.println("supplier");
			return new StringJoiner(" | ");
		}, (j, p) -> {
			System.out.format("accumulator: p=%s; j=%s\n", p, j);
			j.add(p.name.toUpperCase());
		}, (j1, j2) -> {
			System.out.println("merge");
			return j1.merge(j2);
		}, j -> {
			System.out.println("finisher");
			return j.toString();
		});

		String names = persons.stream().collect(personNameCollector);

		System.out.println(names);
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