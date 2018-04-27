package dp.creational.abstract_factory1;

public interface AbstractFactory {
	public AbstractSmartphone createSmartphone();
	
	public AbstractSmartWatch createSmartWatch();
	
	public AbstractLaptop createLaptop();
	
	public AbstractSelfDriveCar createSelfDriveCar();
	
}
