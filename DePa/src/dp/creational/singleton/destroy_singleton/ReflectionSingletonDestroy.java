package dp.creational.singleton.destroy_singleton;

import java.lang.reflect.Constructor;

import dp.creational.singleton.eager_initalized.EagerInitalizedSingleton;

public class ReflectionSingletonDestroy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EagerInitalizedSingleton instanceOne=EagerInitalizedSingleton.getIntance();
		
		EagerInitalizedSingleton instanceTwo=null;
		
		try {
			Constructor[] constructors=EagerInitalizedSingleton.class.getDeclaredConstructors();
			for(Constructor constructor: constructors) {
				//below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo=(EagerInitalizedSingleton) constructor.newInstance();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}
}
