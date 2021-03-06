package howto.collector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapInt2String {

	public static void main(String[] args) {
		List<Person> persons =
		        Arrays.asList(
		            new Person("Max", 18),
		            new Person("Peter", 23),
		            new Person("Pamela", 23),
		            new Person("David", 12));   
		
		Map<Integer, String> map=persons.stream().collect(Collectors.toMap(p->p.age, p->p.name,(name1, name2)-> name1+ ";"+ name2));
		System.out.println(map);
	}
}
