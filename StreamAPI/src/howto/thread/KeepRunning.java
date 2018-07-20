package howto.thread;

import java.util.concurrent.CountDownLatch;

public class KeepRunning {
	
	static CountDownLatch cdl;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cdl=new CountDownLatch(2);
		Thread a=new Thread(()->{
			System.out.println("started a");
			try {
				Thread.sleep(5000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			cdl.countDown();
			System.out.println("stopped a");
		});
		
		Thread b=new Thread(()->  {
			System.out.println("started b");
			System.out.println("wait a");
			try {
				cdl.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("stopped b");
		});
		b.start();
		a.start();
	}

}
