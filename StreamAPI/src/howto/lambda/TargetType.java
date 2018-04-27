package howto.lambda;

public class TargetType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=()-> {
			System.out.println("smt");
		};
		B b=()-> {
			System.out.println("smt");
		};
		
		System.out.println(a.getClass().toString());
		System.out.println(b.getClass().toString());
	}

}

interface A {
	void abstractMethod();
}

interface B {
	void abstractMethod();
}