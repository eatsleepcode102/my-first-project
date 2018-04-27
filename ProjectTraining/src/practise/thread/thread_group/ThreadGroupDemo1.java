package practise.thread.thread_group;

public class ThreadGroupDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup tg=new ThreadGroup("My ThreadGroup");
		MyThread mt=new MyThread(tg, "My Thread");
		mt.start();
	}

}

class MyThread extends Thread {
	public MyThread(ThreadGroup tg, String name) {
		// TODO Auto-generated constructor stub
		super(tg, name);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ThreadGroup tg=getThreadGroup();
		System.out.println(tg.getName());
	}
}
