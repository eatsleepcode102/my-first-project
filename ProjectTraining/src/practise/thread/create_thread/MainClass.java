package practise.thread.create_thread;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Thread first=new TryThread("A", "a", 200L);
		Thread second=new TryThread("B", "B", 200L);
		Thread third=new TryThread("C", "c", 200L);
		
		Thread fourth=new Thread(new TryThreadRunable("D", "d", 600L));
		System.out.println("press enter if you have had enough...");
		first.start();
		second.start();
		third.start();
		fourth.setDaemon(true);
		fourth.start();
		
		System.in.read();
		System.out.println("Enter pressed...");
		
	}

}

class TryThread extends Thread {
	
	public TryThread(String firstName, String secondName, long aWhile) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.aWhile = aWhile;
		setDaemon(true);
	}
	private String firstName;
	private String secondName;
	private long aWhile;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.print(firstName);
			try {
				sleep(aWhile);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(secondName+ "\n");
		}
	}
}

class TryThreadRunable implements Runnable {
	
	public TryThreadRunable(String firstName, String secondName, long aWhile) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.aWhile = aWhile;
	}
	private String firstName;
	private String secondName;
	private long aWhile;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.print(firstName);
			try {
				Thread.sleep(aWhile);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(secondName+ "\n");
		}
	}
}