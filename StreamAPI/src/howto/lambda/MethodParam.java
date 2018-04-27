package howto.lambda;

public class MethodParam {

	public static void main(String[] args) {

		Runnable runable=andThen(()-> System.out.println("r1"), ()-> System.out.println("r2"));
		new Thread(runable).start();
	}
	
	static Runnable andThen(Runnable r1, Runnable r2) {
		return ()->{
			r1.run();
			r2.run();
		};
	}
}
