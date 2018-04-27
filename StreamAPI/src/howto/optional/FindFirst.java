package howto.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirst {

	public static void main(String[] args) {
		// it seems that Optional is able to wrap other object, and we can check status of that wrapping
		List<String> names = Arrays.asList("Bob", "Tom", "Jeff", "Scott", "Jennifer", "Steve");	
		
		//here findFirst method returns a Optional that contains or wraps a String object archived from field method
		Optional<String> firsts=names.stream().filter(name-> name.startsWith("S")).findFirst();
		System.out.println(firsts.orElse("None found"));
		
		Optional<String> otherFirst=names.stream().filter(name-> name.startsWith("J")).findFirst();
		if(otherFirst.isPresent()) {
			System.out.println(otherFirst.get());
		} else {
			System.out.println("No Z is found");
		}
	}
}
