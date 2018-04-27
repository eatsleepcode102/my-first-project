package practise.thead.thread_stop;

class CounterThread extends Thread{
	public boolean stopped=false;
	int count=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!stopped) {
			try {
				sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(count++);
		}
	}
	
	

}

public class UsingBoolean {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CounterThread th=new CounterThread();
		th.start();
		Thread.sleep(10000);
		th.stopped=true;
		System.out.println("Exit");
	}
}