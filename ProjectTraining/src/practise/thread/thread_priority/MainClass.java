package practise.thread.thread_priority;


public class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CounterThread thread1=new CounterThread("thread1");
		thread1.setPriority(10);
		CounterThread thread2=new CounterThread("thread2");
		thread2.setPriority(1);
		thread2.start();
		thread1.start();
	}
	
}
class CounterThread extends Thread{
	
	String name;


	public CounterThread(String name) {
		this.name=name;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count=0;
		while(true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count==140) {
				count=0;
			}
			System.out.println(name+ ":"+ count++);
		}
	}
}