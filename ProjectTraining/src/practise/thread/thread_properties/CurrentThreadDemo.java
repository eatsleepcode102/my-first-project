package practise.thread.thread_properties;

public class CurrentThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t=Thread.currentThread();
		System.out.println("Current Thread :"+ t);
		t.setName("My Thread");
		System.out.println("After name change: "+ t);
		
		try {
			for(int i=0;i<6;i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch(InterruptedException e) {
			
		}
	}

}
