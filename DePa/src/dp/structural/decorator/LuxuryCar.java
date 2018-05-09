package dp.structural.decorator;

public class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car c) {
		// TODO Auto-generated constructor stub
		super(c);
	}

	@Override
	public void assemble() {
		// TODO Auto-generated method stub
		car.assemble();
		System.out.println("Adding features of Luxury Car");
	}
}
