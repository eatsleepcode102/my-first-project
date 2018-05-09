package dp.creational.singleton.eager_initalized;

/**
 * In eager initialization, the instance of singleton class is created at the time of class loading,
 * this is the easiest method to create a singleton class but it has a drawback that instance is create even though client application might not be using it.
 * 
 * If your singleton class is not using a lot of resources, this is the approach to use.
 * But in most of the scenarios, Singleton classes are created for resources such as File system, Database connection etc and
 * we should avoid the instantiation until unless client calls that getIntance method.
 * Also this method doesn't provide any options for exception handling
 * */

public class EagerInitalizedSingleton {
	
	private static final EagerInitalizedSingleton instance= new EagerInitalizedSingleton();
	
	//private constructor to avoid client apps to use constructor;
	private EagerInitalizedSingleton() {}

	public static EagerInitalizedSingleton getIntance() {
		System.out.println("the instance is called");
		return instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EagerInitalizedSingleton.getIntance();
	}

}
