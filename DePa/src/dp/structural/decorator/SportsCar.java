package dp.structural.decorator;

public class SportsCar extends CarDecorator {

	public SportsCar(Car c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void assemble() {
		// TODO Auto-generated method stub
		car.assemble();
		System.out.println("Adding features of Sport Car");
	}
}
