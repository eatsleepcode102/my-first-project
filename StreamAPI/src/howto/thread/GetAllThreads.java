package howto.thread;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GetAllThreads {

	public static void main(String[] args) throws Exception {
		Runnable runnable= new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("Start: "+Thread.currentThread().getName());
					Thread.sleep(100);
				}catch (InterruptedException e) {
					throw new RuntimeException();
				}
			}
		};
		
		Thread one=new Thread(runnable);
		Thread two =new Thread(runnable);
		one.start();
		two.start();
		
		List<Thread> threads=getThreadsFor(runnable);
		for (Thread thread : threads)
		      System.out.println("Found: " + thread.getName());
	}
	
	private static List<Thread> getThreadsFor(Runnable myRunnable) throws Exception {
		Method getThreads=Thread.class.getDeclaredMethod("getThreads");
		Field target=Thread.class.getDeclaredField("target");
		target.setAccessible(true);
		getThreads.setAccessible(true);
		Thread[] threads=(Thread[]) getThreads.invoke(null);
		List<Thread> result=new ArrayList<Thread>();
		for(Thread thread: threads) {
			Object runnable =target.get(thread);
			if(runnable==myRunnable) {
				result.add(thread);
			}
		}
		return result;
	}

}
