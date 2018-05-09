package dp.creational.singleton.lazy_initialization;


/**
 * Lazy initialization method to implement Singleton pattern creates the instance in the global access method.
 * The following implementation works fine in case of single threaded environment but when it comes to multithreaded systems, 
 * it can cause issues if multiple threads are inside the if loop at the same time. It will destroy the singleton pattern and both threads will get the different instances of singleton class.
 * 
 * the following code provides the solution that solve the issues above:
 * the easier way to create a thread-safe singleton class is to make the global access method synchronized, so that only one thread can execute this method at a time.
 * */
public class LazyInitializedSingleton {

	private static LazyInitializedSingleton instance;
	
	//creating private constructor to avoid client apps to use constructor
	private LazyInitializedSingleton() {}
	
	public static  LazyInitializedSingleton getInstance()  {
		if(instance==null) {
		synchronized (LazyInitializedSingleton.class) {
				System.out.println("be created");
				instance= new LazyInitializedSingleton();
			}
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("be ended");
		return instance;
	}
	/**
	 * Above implementation works fine and provides thread-safety but it reduces
the performance because of cost associated with the synchronized method,
although we need it only for the first few threads who might create the
separate instances (Read: Java Synchronization). To avoid this extra
overhead every time, double checked locking principle is used. In this
approach, the synchronized block is used inside if condition with an
additional check to ensure that only one instance of singleton class is
created.
	 * */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyThread().start();
		new MyThread().start();
	}

}

class MyThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LazyInitializedSingleton.getInstance();
	}
	
}
