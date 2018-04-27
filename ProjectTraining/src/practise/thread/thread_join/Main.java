package practise.thread.thread_join;

public class Main {
	  public static void main(String a[]) throws Exception {
	    MyThread tt1 = new MyThread(50);
	    MyThread tt2 = new MyThread(75);
	    Thread t1 = new Thread(tt1, "Test thread 1");
	    Thread t2 = new Thread(tt2, "Test thread 2");
	    t1.start();
	    t2.start();
	    t1.join();
	    if(!t1.isAlive()) {
	    	System.out.println(t1.getName()+": dead");
	    }
	    Thread.sleep(2000);
	    t2.join();
	    if(!t2.isAlive()) {
	    	System.out.println(t2.getName()+": dead");
	    }
	  }
	}

	class MyThread implements Runnable {
	  int i;

	  MyThread(int i) {
	    super();
	    this.i = i;
	  }

	  public void run() {
	     System.out.println(Thread.currentThread().getName() + " " + i);
	  }

	}