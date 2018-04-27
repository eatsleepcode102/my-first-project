package practise.thread.daemon_thread;

class MyThread extends Thread {
	  MyThread() {
	    setDaemon(true);
	  }

	  public void run() {
	    boolean isDaemon = isDaemon();
	    try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("isDaemon:" + isDaemon);
	  }
	}

	public class NonDaemon {
	  public static void main(String[] argv) throws Exception {
	    Thread thread = new MyThread();
	    thread.setDaemon(true);
	    thread.start();
	  }
	}