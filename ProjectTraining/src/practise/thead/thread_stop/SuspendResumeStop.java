package practise.thead.thread_stop;

public class SuspendResumeStop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyThread mt=new MyThread("MyThread");
		Thread.sleep(100);
		mt.suspend();
		Thread.sleep(100);
		
		mt.resume();
		Thread.sleep(100);
		
		mt.suspend();
		Thread.sleep(100);
		
		mt.resume();
		Thread.sleep(100);
		
		mt.stop();
	}
}

class MyThread implements Runnable {

	Thread thd;
	boolean suspended;
	boolean stopped;
	
	public MyThread(String name) {
		thd=new Thread(this, name);
		suspended=false;
		stopped=false;
		thd.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i=1; i<10; i++) {
				System.out.print(".");
				Thread.sleep(50);
				synchronized (this) {
					while(suspended) {
						wait();
						if(stopped) {
							break;
						}
					}
				}
			}
		}catch (InterruptedException  e) {
			System.out.println(thd.getName() + " interrupted.");
		}
		System.out.println("\n" + thd.getName() + " exiting.");
	}
	
	synchronized void stop() {
		stopped=true;
		suspended=false;
		notify();
	}
	
	synchronized void suspend() {
		suspended=true;
	}
	
	synchronized void resume() {
		suspended=false;
		notify();
	}
	
	
}