package dp.structural.decorator;

public class DecoratorPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car sportCar=new SportsCar(new BasicCar());
		sportCar.assemble();
		System.out.println("\n***");
		Car sportsLuxuryCar=new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
	}
}
