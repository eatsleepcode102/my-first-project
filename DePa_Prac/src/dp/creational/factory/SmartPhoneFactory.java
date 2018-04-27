package dp.creational.factory;

public class SmartPhoneFactory {

	public static SmartPhone produceSmartPhone(String kind, String type, String resolution, String ram) {
		if(kind.equals("nokia")) {
			return new Nokia(type, resolution, ram); 
		} else if(kind.equals("samsung")) {
			return new SamSung(type, resolution, ram); 
		} else {
			return null;
		}
	}
}
