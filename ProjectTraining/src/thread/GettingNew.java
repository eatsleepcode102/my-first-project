package thread;

public class GettingNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass myClass=new MyClass();
		myClass.print();
	}

}


class MyClass {
	public static void print() {
		class Printer {
			public Printer(String a) {
				// TODO Auto-generated constructor stub
				System.out.println("asdfasdfasd");
			}
		}
		
		new Printer("j");
		
		System.out.println("after class");
	}
}