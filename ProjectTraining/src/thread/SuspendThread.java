package thread;

public class SuspendThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewThread ob1=new NewThread("One");
		NewThread ob2=new NewThread("Two");
		try {
			Thread.sleep(1000);
			ob1.mysuspend();
			System.out.println("Suspending thread one");
			Thread.sleep(1000);
			ob1.myresume();
			ob2.mysuspend();
		      System.out.println("Suspending thread Two");
		      Thread.sleep(1000);
		      ob2.myresume();
		      System.out.println("Resuming thread Two");
			System.out.println("Resuming thread one");
		} catch(InterruptedException e) {
			System.out.println("main thread interrupted");
		}
		
		 try {
		      System.out.println("Waiting for threads to finish.");
		      ob1.t.join();
		      ob2.t.join();
		    } catch (InterruptedException e) {
		      System.out.println("Main thread Interrupted");
		    }

		    System.out.println("Main thread exiting.");
	}

}

class NewThread implements Runnable{

	String name;
	Thread t;
	boolean suspendFlag;
	public NewThread(String threadName) {
		// TODO Auto-generated constructor stub
		name=threadName;
		t=new Thread(this, name);
		System.out.println("New THread: "+t);
		suspendFlag=false;
		t.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i=15;i>0;i--) {
				System.out.println(name+ ": "+i);
				Thread.sleep(200);
				synchronized (this) {
					while(suspendFlag) {
						wait();
					}
				}
			}
		}catch(InterruptedException e) {
			System.out.println(name+" interupted");
		}
		System.out.println(name+ "exiting");
	}
	
	void mysuspend() {
		suspendFlag=true;
	}
	synchronized void myresume() {
		suspendFlag=false;
		notify();
	}
}