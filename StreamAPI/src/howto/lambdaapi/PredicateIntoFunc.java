package howto.lambdaapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateIntoFunc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("XML", "HTML", "Java", "Javascript", "CSS", "C");
		Function<String, Predicate<String>> startsWithLetter=letter -> name -> name.startsWith(letter); //letter is parameter of predicate
		
		names.stream().filter(startsWithLetter.apply("J")).forEach(System.out::println);
		
	}
}
