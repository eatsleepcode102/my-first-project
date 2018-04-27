package howto.intstream;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class GenerateConstantValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStream.generate(()-> 1).limit(5).forEach(System.out::println);
		
//		IntStream.rangeClosed(1, 10).forEach(num -> System.out.println(num));
//		   
//	    System.out.println("");
//	    
//	    IntStream.range(1, 10).forEach(num -> System.out.println(num));
//	    
//	    
	    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);	
	    
	    System.out.println(
	    	      numbers.stream()
	    	      .filter(i->i%2==0 && i>2)
	    	      .mapToInt(i->i*i)
	    	      .findFirst()
	    	      .getAsInt()
	    	    );
	    
	    String s= "13";
		int result=s.chars().filter(Character::isDigit).map(ch-> Character.valueOf((char) ch)).sum();
		System.out.println("result:"+result);
		System.out.printf("%d is prime:"+isPrime(123), 123);
	}
	
	//Check if a integer is a prime number
	public static boolean isPrime(int number) {
		IntPredicate isDivisible=index-> number% index==0;
		return number>1 && IntStream.range(2, number-1).noneMatch(isDivisible);
		}
	
}
