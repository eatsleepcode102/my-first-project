package practise.thread.thread_group;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ThreadGroup tg = Thread.currentThread().getThreadGroup();
		MyThread1 mt1 = new MyThread1(tg, "first");
		MyThread1 mt2 = new MyThread1(tg, "second");
		mt1.start();
		mt2.start();
		ThreadGroup parent = tg.getParent();
		Thread[] list = new Thread[parent.activeCount()];
		int count = parent.enumerate(list, true);
		String[] thdinfo = new String[count];
		for (int i = 0; i < count; i++)
			thdinfo[i] = list[i].toString();

		mt1.join();
		mt2.join();

		for (int i = 0; i < count; i++)
			System.out.println(thdinfo[i]);
	}

}

class MyThread1 extends Thread {
	MyThread1(ThreadGroup tg, String name) {
		super(tg, name);
	}

	public void run() {
		for (char c = 'A'; c <= 'Z'; c++)
			System.out.println(c);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}
}