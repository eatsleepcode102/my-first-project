package howto.lambdaapi;

import java.util.function.BinaryOperator;

public class BinaryOper {

	public static void main(String[] args) {
		BinaryOperator<String> bi=(s1, s2)-> s1+s2;
		String result=bi.apply("Just", "java8");
		System.out.println(result);
		
	}

}
