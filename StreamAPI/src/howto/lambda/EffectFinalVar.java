package howto.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class EffectFinalVar {

	public static void main(String[] args) {
		List<Integer> l=Arrays.asList(1, 3, 2, 4, 7, 8, 9, 6, 5);
		IntWrapper variableOutside=new IntWrapper(50);
		Consumer<Integer> consumer=i ->{
			int variableInside=70;
			System.out.println(variableOutside.getInt());
			variableOutside.incr();
			variableInside++;
			System.out.printf("%s plus %d plus %d equals %d\n", variableOutside, variableInside, i, variableOutside.getInt()+ variableInside +i);
			
		};
		variableOutside.incr();
		l.forEach(consumer);

	}
}

class IntWrapper {
	private int data;

	public IntWrapper(int data) {
		this.data = data;
	}

	public String toString() {
		return this.data + "";
	}

	public void incr() {
		this.data++;
	}

	public int getInt() {
		return this.data;
	}
}