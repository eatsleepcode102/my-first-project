package practise.thread.thread_priority;

public class ThreadDemo extends Thread {

	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i< 5; i++) {
			compute();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadDemo thread1 = new ThreadDemo();

	    // Create the second thread by passing a Runnable object to the
	    // Thread() construtor. The body of this thread is the run() method
	    // of the anonymous Runnable object below.
	    Thread thread2 = new Thread(new Runnable() {
	      public void run() {
	        for (int i = 0; i < 5; i++)
	          compute();
	      }
	    });

	    // Set the priorities of these two threads, if any are specified
	    if (args.length >= 1)
	      thread1.setPriority(Integer.parseInt(args[0]));
	    if (args.length >= 2)
	      thread2.setPriority(Integer.parseInt(args[1]));

	    // Start the two threads running
	    thread1.start();
	    thread2.start();

	    // This main() method is run by the initial thread created by the
	    // Java interpreter. Now that thread does some stuff, too.
	    for (int i = 0; i < 5; i++)
	      compute();
	}
	
	static ThreadLocal numcalls=new ThreadLocal();
	static synchronized void compute() {
		Integer n=(Integer) numcalls.get();
		if(n==null) {
			n=new Integer(1);
		} else {
			n=new Integer(n.intValue()+1);
		}
		numcalls.set(n);
		System.out.println(Thread.currentThread().getName()+ ": "+n);
		for (int i = 0, j = 0; i < 1000000; i++) {
		      j += i;
		}
		  try {
		      Thread.sleep((int) (Math.random() * 100 + 1));
		    } catch (InterruptedException e) {
		    }
		    Thread.yield();
	}
}
