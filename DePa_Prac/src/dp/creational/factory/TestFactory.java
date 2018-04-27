package dp.creational.factory;

public class TestFactory {

	public static void main(String[] args) {
		SmartPhone smno= SmartPhoneFactory.produceSmartPhone("nokia", "n21", "768x1024", "3GB");
		System.out.println("nokia: "+ smno);
	}
}
