package howto.lambda;

public class NewThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runThreadUseLambda();
		runThreadUseInnerClass();
	}	
	
	public static void runThreadUseLambda() {
		new Thread(() -> System.out.println("this is like runnable")).start();
	}
	
	public static void runThreadUseInnerClass() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("this is runnable");
			}
		}).start();;
	}
}
