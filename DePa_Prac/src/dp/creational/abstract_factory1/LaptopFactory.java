package dp.creational.abstract_factory1;

public class LaptopFactory {
	public static AbstractLaptop getLaptop(AbstractFactory factory) {
		return factory.createLaptop();
	}
}	
