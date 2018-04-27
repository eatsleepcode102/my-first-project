package dp.creational.abstract_factory1;

public class SelfDriveCarProducer { //or SelfDriveCarFactory
	
	public static AbstractSelfDriveCar getSelfDriveCar(AbstractFactory factory) {
		return factory.createSelfDriveCar();
	}
}
