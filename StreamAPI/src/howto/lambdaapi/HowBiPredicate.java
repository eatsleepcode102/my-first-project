package howto.lambdaapi;

import java.util.function.BiPredicate;

public class HowBiPredicate {

	public static void main(String[] args) {
		boolean result= compare((a, b)-> a/2==b, 10	, 5);
		System.out.println(result);
	}

	public static boolean compare(BiPredicate<Integer, Integer> bi, Integer i1, Integer i2) {
		return bi.test(i1, i2);
	}
}
