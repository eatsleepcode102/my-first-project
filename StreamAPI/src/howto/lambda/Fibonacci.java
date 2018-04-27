package howto.lambda;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int range=100;
		System.out.println("Sum of even fibonacci number less then "
				+ range
				+ " is"
				+ fibonacciOperation(i-> i< range, (sum, i) -> i%2==0? sum+i: sum));
		System.out.println("Sum of odd fibonacci number less then "
                + range
                + " is "
                + fibonacciOperation(i -> i < range,(sum, i) -> i % 2 != 0 ? sum + i : sum));
	}
	
	private static int fibonacci(int n) {
		if(n==0) {
			return 0;
		} else if(n==1) {
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	
	private static int fibonacciOperation(Predicate<Integer> condition, BinaryOperator<Integer> operation) {
		int i=0;
		int result=0;
		int fibo=fibonacci(i);
		for(int temp=operation.apply(result, fibo); condition.test(temp); fibo=fibonacci(i), temp=operation.apply(result, fibo)) {
			System.out.println(fibo + " ");
			result=temp;
			i++;
		}
		return result;
	}
}
