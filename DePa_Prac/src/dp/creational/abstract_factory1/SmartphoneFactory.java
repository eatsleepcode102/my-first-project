package dp.creational.abstract_factory1;

public class SmartphoneFactory {
	public static AbstractSmartphone getSmartphone(AbstractFactory factory) {
		return factory.createSmartphone();
	}
}
