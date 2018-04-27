package howto.lambda;

public class MyThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Anonymous way
		Runnable r1=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Hello "+Thread.currentThread().getName());
			}
		};
		
		//runnable is already a functional interface
		Runnable r2=()-> {
			System.out.println("Hi "+ Thread.currentThread().getName());
		};
		//start
		new Thread(r1).start();
		new Thread(r2).start();
	}

}
