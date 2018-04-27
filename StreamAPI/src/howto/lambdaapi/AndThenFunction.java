package howto.lambdaapi;

import java.util.function.Function;

public class AndThenFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer, Integer> first=(n)-> n+2;
		Function<Integer, Integer> second=(n)-> n-1;
		System.out.println(first.andThen(second).apply(3));
		
		/*
		 * run: result: 4
		 * 
		 * look at the result we can see, the result of first function will be applied to second function
		 */
		
	}

}
