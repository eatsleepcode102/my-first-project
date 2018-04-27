package practise.thread.sync;

public class TestSynchronized {

	int taskID;
	//just remove synchronize key word to test case un-synchronized
	public synchronized void performATask(int val) {
		taskID=val;
		print("before: "+taskID);
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		print("after: "+ taskID);
	}
	
	public static void print(String msg) {
		System.out.println(Thread.currentThread().getName()+":"+ msg);
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final TestSynchronized tus=new TestSynchronized();
		Runnable runA=new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				tus.performATask(1);
			}
			
		};
		Thread ta=new Thread(runA,"threadA");
		ta.start();
		Thread.sleep(1);
		
		Runnable runB = new Runnable() {
		      public void run() {
		        tus.performATask(2);
		      }
		    };

		    Thread tb = new Thread(runB, "threadB");
		    tb.start();
	}

}
