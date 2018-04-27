package howto.lambda;

public class ReturnALambda {

	public static void main(String[] args) {
		
		new Thread(uncheck(()-> { // these line of code implements the execution of accept() method
			Thread.sleep(1000);
			System.out.println("Done");
		})).start();;
	}
	
	private static Runnable uncheck(RunnableEx ex) {
		return ()->{
			try {
				ex.accept();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}
}

interface RunnableEx {
	public abstract void accept() throws InterruptedException;
}