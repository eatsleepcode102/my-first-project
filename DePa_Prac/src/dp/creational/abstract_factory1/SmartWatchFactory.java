package dp.creational.abstract_factory1;

public class SmartWatchFactory {
	
	public static AbstractSmartWatch getSmartWatch(AbstractFactory factory) {
		return factory.createSmartWatch();
	}
}
