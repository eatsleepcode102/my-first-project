package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExeServiceClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintTask ta1=new PrintTask("thread1");
		PrintTask ta2=new PrintTask("thread2");
		PrintTask ta3=new PrintTask("thread3");
		
		System.out.println("starting threads");
		ExecutorService thExecutorService=Executors.newCachedThreadPool();
		thExecutorService.execute(ta1);
		thExecutorService.execute(ta2);
		thExecutorService.execute(ta3);
		thExecutorService.shutdown();
		System.out.println("Thread started, main ends \n");
	}

}

class PrintTask implements Runnable {

	private int sleepTime;
	private String threadName;
	
	public PrintTask(String name) {
		// TODO Auto-generated constructor stub
		threadName=name;
		sleepTime=1000;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.printf("%s going to sleep for %d milliseconds.\n", threadName, sleepTime);
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s done sleeping \n", threadName);
	}
	
}