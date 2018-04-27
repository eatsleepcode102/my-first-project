package practise.thread.daemon_thread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public class SyncCollections {
  @SuppressWarnings("unchecked")
public static void main(String[] a) {
    Set<String> s = new HashSet();
    s.add("A");
    s.add("B");
    s.add("C");
    s.add("D");
    s.add("E");
    s.add("F");
    s.add("H");
    Set<String> s1=Collections.synchronizedSet(s);
    System.out.println(s);
    
    new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			int i=0;
			try {
				while(true) {
					if(i>5) break;
						s1.add(i+++"");
						Thread.sleep(500);
				}
			} catch(Exception e) {
			}
			System.out.println(s1);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread 1 Interrupted");
		}
	}).start();
    
    new Thread(new Runnable() {
		
  		@Override
  		public void run() {
  			// TODO Auto-generated method stub
  			int j=0;
  			try {
  				while(true) {
  					if(j>5) break;
  						s1.add(j+++"");
  						Thread.sleep(400);
  				}
  			} catch(Exception e) {
  			}
  			System.out.println(s1);
  			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  			System.out.println("Thread 2 Interrupted");
  		}
  	}).start();
  }
}

