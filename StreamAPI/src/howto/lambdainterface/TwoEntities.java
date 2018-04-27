package howto.lambdainterface;

public class TwoEntities {

	public static void main(String[] args) {
		MyCal<Integer> myCalc=(a, b)-> a+b;
		System.out.println("Sum: "+ myCalc.calcIt(5, 5));
		
		MyCal<String> myadder=(a, b)-> a+b;
		System.out.println("Adder :"+ myadder.calcIt("a", "b"));
	}
}

interface MyCal<T>{
	public T calcIt(T t1, T t2);
}