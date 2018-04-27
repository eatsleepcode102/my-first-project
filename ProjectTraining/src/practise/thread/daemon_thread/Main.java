package practise.thread.daemon_thread;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyDaemon dt=new MyDaemon();
		if(dt.isDaemon()) {
			System.out.println("dt is a daemon thread");
		}
		Thread.sleep(3000);
		 System.out.println("\nMain thread ending.");
	}
}


class MyDaemon implements Runnable {

	Thread thd;
	public MyDaemon() {
		// TODO Auto-generated constructor stub
		thd=new Thread(this);
		thd.setDaemon(true);
		thd.start();
	}
	
	public boolean isDaemon() {
		return thd.isDaemon();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				System.out.print(".");
				Thread.sleep(100);
			}
		} catch(Exception e) {
			System.out.println("MyDaemon Interruped");
		}
	}
}