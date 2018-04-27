package howto.intstream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class IntArrayToIntStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers= new Random().ints(1, 50).limit(7).toArray();
		IntStream intStream=Arrays.stream(numbers);
		
		IntStream.builder().add(1).add(5).build().average().ifPresent(System.out::println);
		intStream=intStream.limit(3);
		System.out.println(intStream.sum());
	}
}
