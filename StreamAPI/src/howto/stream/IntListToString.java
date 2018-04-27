package howto.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntListToString {

	public static void main(String[] args) {
		//we would like to know how to collect List of Integer to a String with separator
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		System.out.println(numbers.stream().map(number-> String.valueOf(number)).collect(Collectors.joining(", ")));
		
		System.out.println("Collect list: "+numbers.stream().filter(t->t >4).collect(Collectors.toList()));
	}
}
