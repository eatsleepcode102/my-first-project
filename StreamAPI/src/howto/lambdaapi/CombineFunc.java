package howto.lambdaapi;

import java.util.function.Function;

public class CombineFunc {

	public static void main(String[] args) {
		Function<String, Integer> toInteger=Integer::valueOf;
		Function<String, String> backToString=toInteger.andThen(String::valueOf);
		
		System.out.println(backToString.apply("123"));
	}
}
