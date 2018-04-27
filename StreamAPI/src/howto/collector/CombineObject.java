package howto.collector;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

public class CombineObject {

	public static void main(String[] args) {
		//we would like to know how to create collector from supplier accumulator combiner, and finisher
		List<Person> persons =
		        Arrays.asList(
		            new Person("Max", 18),
		            new Person("Peter", 23),
		            new Person("Pamela", 23),
		            new Person("David", 12));   

		 Collector<Person, StringJoiner, String> personNameCollector =
			        Collector.of(
			            () -> new StringJoiner(" | "),          // supplier
			            (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
			            (j1, j2) -> j1.merge(j2),               // combiner
			            StringJoiner::toString);                // finisher

			    String names = persons
			        .stream()
			        .collect(personNameCollector);

			    System.out.println(names);
	}

}

