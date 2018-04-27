package thread;

public class ThreadUsingLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t =new Thread(() ->  {
			System.out.println("Running in another thread");
		});
		t.start();
	}

}
