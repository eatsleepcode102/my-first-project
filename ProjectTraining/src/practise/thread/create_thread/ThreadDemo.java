package practise.thread.create_thread;

public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NewThread();
		new MoreNewThread();
		for(int i=5;i>0;i--) {
			System.out.println("Main thread: "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Exiting main thread");
	}

}

class NewThread implements Runnable {

	Thread t;
	
	
	public NewThread() {
		t=new Thread(this, "Demo thread");
		System.out.println("child thread :"+t);
		t.start();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=5;i>0;i--) {
			System.out.println("Child thread: "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Exiting child thread");
	}
	
}

class MoreNewThread extends Thread {

	public MoreNewThread() {
		// TODO Auto-generated constructor stub
		System.out.println("Child thread-"+ this);
		start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=5;i>0;i--) {
			System.out.println("Child thread: "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Exiting more child thread");
	}
	
}