package dp.creational.singleton.bill_pugh_implementation;

public class BillPughSingleton {
	
	private BillPughSingleton() {}

	
	private static class SingletonHelper {
		private static BillPughSingleton INSTANCE=new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance() {
		System.out.println("be created");
		return SingletonHelper.INSTANCE;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BillPughSingleton.getInstance();
	}
}
