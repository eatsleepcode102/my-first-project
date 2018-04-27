package thread;

public class WaitComm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}

class WFlagSend implements Runnable {

	volatile int theValue;
	boolean isValid;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i< 5;i++) {
			synchronized (this) {
				while(isValid) {
					try {
						this.wait();
					} catch(InterruptedException e) {}
				}
			}
		}
	}
	
}