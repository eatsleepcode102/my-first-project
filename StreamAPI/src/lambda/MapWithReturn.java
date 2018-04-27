package lambda;


import java.util.*;

public class MapWithReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int va = 0;
		(new Random()).ints(1, 50).limit(10).asLongStream().map(i->{
////			va+=(int) i;
			System.out.println("va="+inreaseValue(va, i));
			return i+1;
			
		}).forEach(System.out::println);
	}
	
	public static int inreaseValue(int sum,long i) {
		return sum+=i;
	}

}
