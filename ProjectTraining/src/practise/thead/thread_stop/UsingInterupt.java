package practise.thead.thread_stop;

public class UsingInterupt {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread first=new TryThread("A", "a", 200l);
		Thread second=new TryThread("B", "b", 200l);
		Thread third=new TryThread("C", "c", 200l);
		first.start();
		second.start();
		third.start();
		TryThread.sleep(3000);
		first.interrupt();
		second.interrupt();
		third.interrupt();
	}

}

class TryThread extends Thread {
	private String firstName;
	private String secondName;
	private long aWhile;
	public TryThread(String firstname, String secondName, long delay) {
		// TODO Auto-generated constructor stub
		this.firstName=firstname;
		this.secondName=secondName;
		this.aWhile=delay;
		setDaemon(true);
	}
	@Override
	public void run() {
		while(true) {
			try {
				System.out.print(firstName);
				sleep(aWhile);
				System.out.print(secondName+"\n");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(firstName + secondName + e);
			}
		}
	}
}