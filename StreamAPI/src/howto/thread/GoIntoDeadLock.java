package howto.thread;

public class GoIntoDeadLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student a=new Student("A");
		Student b=new Student("B");
//		new Thread(()-> a.bow(b)).start();
//		new Thread(()-> b.bow(a)).start();
		new Thread(()-> a.bindName()).start();
		new Thread(()-> a.bindName()).start();
	}

}
class Student {
	
	public String MUTEXT=new String();
	  String name;
	  public Student(String name) {
	    this.name = name;
	  }
	  public String getName() {
	    return this.name;
	  }
	  public synchronized void bow(Student bower) {
	    System.out.format("%s: %s" + " is waiting for me!%n", this.name,
	        bower.getName());
	    bower.bowBack(this);
	  }
	  public synchronized void bowBack(Student bower) {
	    System.out.format("%s: %s" + " is waiting for me!%n", this.name,
	        bower.getName());
	  }
	  
	  public void bindName() {
		  synchronized (MUTEXT) {
			  
			  System.out.println(Thread.currentThread().getName()+":"+ this.name);
			  try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  }
	}