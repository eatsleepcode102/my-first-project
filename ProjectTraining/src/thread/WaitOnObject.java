package thread;

public class WaitOnObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Object monitor=new Object();
		new Thread() {
			public void run() {
				try {
					synchronized (monitor) {
						System.out.println("10 seconds...");
						monitor.wait(2000);
						System.out.println("Wait over");
					}
				} catch (Throwable t) {}
			}
		}.start();
	}

}
