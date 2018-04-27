package lambda;

import java.util.function.BiFunction;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		engine((double x, double y)-> y/x);
		System.out.println(create().calculate(4, 5));
		
		Predicate<String> i=(s)-> s.length()>5;
		System.out.println(i.test("That's all"));
		
		/*Method references*/
		//static method reference
		///ex1
		//// Using a lambda expression
		Function<Integer, String> func1= x-> Integer.toBinaryString(x);
		System.out.println(func1.apply(10));
		
		//// Using a method reference
		
		Function<Integer, String> func2=Integer::toBinaryString;
		System.out.println(func2.apply(10));
		
		///ex2
		//// Using a lambda expression
		BiFunction<Integer, Integer, Integer> funcex1=(a, b)-> Integer.sum(a, b);
		System.out.println(funcex1.apply(2, 3));
	}

	public static void engine(DoubleCalculator calculator) {
		double x=2.2, y=8.4;
		System.out.println(calculator.calculate(x, y));
	}
	
	public static void engine(IntCalculator calculator) {
		int x=3, y=15;
		System.out.println(calculator.calculate(x, y));
	}
	
	public static DoubleCalculator create() {
		return (x,y)-> x +y;
	}
	
}

@FunctionalInterface
interface Calculator {
	public Integer calculate(int x, int y);
//	public int getStringLength(String str);
}
@FunctionalInterface
interface DoubleCalculator {
	public double calculate(double x, double y);
}
@FunctionalInterface
interface IntCalculator {
	public int calculate(int x, int y);
}

interface StringMeasuror {

}