package dp.creational.abstract_factory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String factoryType) {
		if(factoryType.equals("printer")) {
			return new PrinterFactory();
		} else if(factoryType.equals("shape")) {
			return new ShapeFactory();
		} else {
			return null;
		}
	}
}
