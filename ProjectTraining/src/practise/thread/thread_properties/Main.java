package practise.thread.thread_properties;

public class Main extends Thread {
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 for (int i = 0; i < 5; i++) {
		      printMyName();
		    }
	}
	
	public void printMyName() {
		System.out.println("The Thread name is "+ Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main ttsn=new Main();
		ttsn.setName("Created One");
		ttsn.start();
		Thread t2=currentThread();
		t2.setName("main one");
		 for (int i = 0; i < 5; i++) {
		      ttsn.printMyName();
		    }
	}

}
