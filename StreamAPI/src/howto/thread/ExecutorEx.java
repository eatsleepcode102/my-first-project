package howto.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorEx {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Random RND=new Random();
		ExecutorService es=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		List<Future<String>> results=new ArrayList<>(10);
		for(int i=0; i< 10; i++) {
			results.add(es.submit(new TimeSliceTask(RND.nextInt(10), TimeUnit.SECONDS)));
		}
		es.shutdown();
		while(!results.isEmpty()) {
			Iterator<Future<String>> i=results.iterator();
			while(i.hasNext()) {
				Future<String> f=i.next();
				if(f.isDone()) {
					System.out.println(f.get());
					i.remove();
				}
			}
		}
	}

}


class TimeSliceTask implements Callable<String>{

	long timeToLive;
	long duration;
	
	public TimeSliceTask(final long timeToLive, final TimeUnit timeUnit) {
		this.timeToLive=System.nanoTime() + timeUnit.toNanos(timeToLive);
		this.duration=timeUnit.toMillis(timeToLive);
	}
	
	@Override
	public String call() throws Exception {
		while(timeToLive<= System.nanoTime()) {
			Thread.sleep(500);
		}
		final long end=System.nanoTime();
		return String.format("Finished Elapsed Time = %d, scheduled for %d",
		        TimeUnit.NANOSECONDS.toMillis(timeToLive - end), this.duration);
	}
}