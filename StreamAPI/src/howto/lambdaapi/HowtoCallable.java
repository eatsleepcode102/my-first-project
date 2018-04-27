package howto.lambdaapi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class HowtoCallable {

	public static void main(String[] args) throws Exception {
		
		List<Integer> nums=new ArrayList<Integer>();
		nums.add(3);
		nums.add(8);
		nums.add(11);
		
		Callable<Integer> c=()-> {
			int sum=0;
			for(Integer i: nums) {
				sum+=i;
			}
			return sum;
		};
		
		System.out.println(c.call());
		nums.add(1);
		System.out.println(c.call());
		
	}

}
