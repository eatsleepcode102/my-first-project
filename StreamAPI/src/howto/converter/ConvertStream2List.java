package howto.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertStream2List {

	public static void main(String[] args) {
		Stream<String> words = Stream.of("All", "men", "are", "created", "equal");
		List<String> wordsList=words.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		wordsList.forEach(n-> System.out.println(n));
		
		// how to convert Array to Stream
		Stream.of("this", "is", "java8", "stream").forEach(System.out::println);
		String[] strArr=new String[] {"a", "V", "f"};
		Arrays.stream(strArr).forEach(System.out::println);
		
		//we would like to know how to convert Integer to String with map
		Arrays.asList(1,20,30,40).stream().filter(n->n>=20).map(n->"num:"+ String.valueOf(n)).forEach(System.out::println);
		
		//how to convert String Stream to join them
		Stream<String> words1 = Stream.of("All", "men", "are", "created", "equal");
		System.out.println(words1.collect(Collectors.joining(".")));
	}
}
