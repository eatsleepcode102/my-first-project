package practise.thread.thread_priority;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable runner = new MyRunnable("first");
		Thread t = new Thread(runner);
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		runner = new MyRunnable("second");
		t = new Thread(runner);
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();
	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println(name);
		}
	}
	protected String name;

	public MyRunnable(String ts) {
		name = ts;
	}
}