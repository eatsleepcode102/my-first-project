package dp.creational.singleton.enum_singleton;

//we should use enum singleton implementation in java 5 because of some reason that related to performance and memory 
public enum EnumSingleton implements MySingleton {

	INSTANCE;
	
	public void doSomething() {
		System.out.println("Singleton using Enum");
	}
}

interface MySingleton {
	void doSomething();
} 