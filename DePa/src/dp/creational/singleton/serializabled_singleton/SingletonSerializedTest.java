package dp.creational.singleton.serializabled_singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SingletonSerializedTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		SerializabledSingleton instanceOne=SerializabledSingleton.getInstance();
		ObjectOutput out=new ObjectOutputStream(new FileOutputStream("filename.ser"));
		out.writeObject(instanceOne);
		out.close();
		
		ObjectInput in=new ObjectInputStream(new FileInputStream("filename.ser"));
		SerializabledSingleton instanceTwo=(SerializabledSingleton) in.readObject();
		in.close();
		
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}
}
