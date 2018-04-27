package howto.collector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupPersonByAttr {

	public static void main(String[] args) {
		List<Person> persons =
		        Arrays.asList(
		            new Person("Max", 18),
		            new Person("Peter", 23),
		            new Person("Pamela", 23),
		            new Person("David", 12));  
	
		Map<Integer, List<Person>> personByAge=persons.stream().collect(Collectors.groupingBy(p-> p.age));
		System.out.println(personByAge);

	}

}
