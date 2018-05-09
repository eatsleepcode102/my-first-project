package dp.creational.singleton.serializabled_singleton;

import java.io.Serializable;

//sometimes in distributed systems, we need to implement Seriazable interface in Singleton class
// so that we can store its state in file system and retrieve it later point of time

public class SerializabledSingleton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SerializabledSingleton() {}
	
	private static class SingletonHelper {
		private static final SerializabledSingleton instance=new SerializabledSingleton();
	}
	
	public static SerializabledSingleton getInstance() {
		return SingletonHelper.instance;
	}
	
	// this method is called after calling readObject
	// this ensures that we can create a new instance by serializing or deserializing singleton
	protected Object readResolve() {
		return getInstance();
	}
}
