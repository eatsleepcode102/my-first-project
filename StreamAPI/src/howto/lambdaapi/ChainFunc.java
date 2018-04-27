package howto.lambdaapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ChainFunc {

	public static void main(String[] args) {
		
		Function<Integer, Integer> first=(i)-> i*2;
		Function<Integer, Integer> second=(i)-> i+1;
		System.out.println(first.compose(second).apply(2));
		
		/*
		 *when we use andThen then the result is 5, compose will five us the result is 6 
		 *-> compose will perform the function argument firstly 
		 */
		
		
		
		Function<Double, Double> square=number-> number * number;
		Function<Double, Double> half=number-> number*2;
		
		List<Double> numbers = Arrays.asList(2D, 4D, 6D);
		
		//pay attention to the order
		System.out.println(mapIt(numbers, square.compose(half)));// perform half first and and then perform square
		System.out.println(mapIt(numbers, half.compose(square)));
		
		System.out.println(mapIt(numbers, half.andThen(square)));// this is the same with the one
	}

	private static List<Double> mapIt(List<Double> numbers, Function<Double, Double> fx ) {
		List<Double> result =new ArrayList<>();
		for(Double number:numbers) {
			result.add(fx.apply(number));
		}
		return result;
	}
}
