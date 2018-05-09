package dp.creational.singleton.static_block;

/**
 * static block initialization implementation is similar to eager initialization,
 * except that instance of class is create in the static block that provides option for exception handling
 * 
 * note: Both eager initialization and static block initialization creates the instance even before its being used and that it not the best practice to use,
 * So in further sections, we will learn how to create singleton class that supports lazy initialization
 * */

public class StaticBlockSingleton {
	
	private static StaticBlockSingleton instance;
	
	//using this private constructor to avoid client app to use constructor
	private StaticBlockSingleton() {};
	
	static {
		try {
		instance=new StaticBlockSingleton();
		throw new Exception();
		} catch (Exception e) {
			System.out.println("exception occurred upon creating instance");
		}
	}
	
	public static StaticBlockSingleton getInstance() {
		System.out.println("be created");
		return instance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticBlockSingleton.getInstance();
	}

}
