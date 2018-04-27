package howto.collector;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class HowtoConcurrentMap {

	public static void main(String[] args) {
		List<String> strings = new LinkedList<>();
        strings.add("a");
        strings.add("B");
        strings.add("ab");
        strings.add("abc");
        strings.add("ABC");

        ConcurrentMap<Integer, List<String>> byLength=strings.parallelStream().collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(byLength);
        
        //the following code show how to collect to Count element
        System.out.println(strings.stream().collect(Collectors.counting())+"");
        
	}
}
