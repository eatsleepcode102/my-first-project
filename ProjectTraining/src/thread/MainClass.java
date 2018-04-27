package thread;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CounterThread t =new CounterThread();
		t.start();
		//after this run() method is executing its task
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
//		t.stopped=true;
		t.interrupt();// we must set t thread is Deamon then we can use interrupt method to stop it
		System.out.println("exit");
	}

}

class CounterThread extends Thread {
	
	public CounterThread() {
		// TODO Auto-generated constructor stub
		setDaemon(true);
	}
	public boolean stopped=false;
	int count=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!stopped) {
			try {
				sleep(100);
			} catch(InterruptedException e) {
				
			}
			System.out.println(count++);
		}
	}
	
}
