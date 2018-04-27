package howto.lambda;

import java.util.function.UnaryOperator;

public class Recursive {
	static UnaryOperator<Integer> factorial=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factorial=i-> i==0? 1:i * factorial.apply(i-1);
		System.out.println(factorial.apply(4));
	}
}
