package howto.lambda;

import java.util.Arrays;
import java.util.Random;

public class RandomInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ints=new Random().ints(1, 50).distinct().limit(7).toArray();
		System.out.println(Arrays.toString(ints));
	}
}
