package thread;

/*
 * in this programming, when the thread1 perform its task- call synchronized method,
 * after the calling, syn method is locked, so the thread2 executive its task but must wait ultil
 * the thread1 release the syn method
 * 
 * */

public class TestSynchronized {
	int taskID;
	
//	public synchronized void performATask(int val) {
		public  void performATask(int val) {
		taskID=val;
		print("before: "+taskID);
		try {
			Thread.sleep(4000);
		} catch(InterruptedException e) {
			
		}
		print("after: "+taskID);
	}
	
	public static void print(String msg) {
		System.out.println(Thread.currentThread().getName() + ": "+msg);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TestSynchronized tus=new TestSynchronized();
		
		Runnable runA=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				tus.performATask(1);
			}
		};
		Thread ta=new Thread(runA,"threadA");
		ta.start();
		Thread.sleep(0);
		Runnable runB = new Runnable() {
		      public void run() {
		        tus.performATask(2);
		      }
		    };

		    Thread tb = new Thread(runB, "threadB");
		    tb.start();
	}

}
