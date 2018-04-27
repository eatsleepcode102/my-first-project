package practise.thread.thread_priority;

public class HighLowPri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		Clicker hi=new Clicker(Thread.NORM_PRIORITY+2);
		Clicker lo=new Clicker(Thread.NORM_PRIORITY-2);
		lo.start();
		hi.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lo.stop();
		hi.stop();
		try {
		      hi.t.join();
		      lo.t.join();
		    } catch (InterruptedException e) {
		      System.out.println("InterruptedException caught");
		    }

		    System.out.println("Low-priority thread: " + lo.click);
		    System.out.println("High-priority thread: " + hi.click);
	}

}

class Clicker implements Runnable {

	int click=0;
	Thread t;
	
	private volatile boolean running=true;
	
	public Clicker(int p) {
		t =new Thread(this);
		t.setPriority(p);
	}
	
	@Override
	public void run() {
		while(running) {
			click++;
		}
	}
	
	public void stop() {
		running=false;
	}
	public void start() {
		t.start();
	}
	
}