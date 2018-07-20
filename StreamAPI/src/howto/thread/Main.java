package howto.thread;
import java.lang.Thread.UncaughtExceptionHandler;

public class Main {

	public static void main(String[] args) {
		Thread thread= new Thread() {
			public void run() {
				throw new NullPointerException();
			};
		};
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("be caught");
//				e.printStackTrace();
			}
		});
		try {
		thread.start();
		} catch (Exception e) {
			System.out.println("be caught by try/catch block");
		}
	}

}
