package dp.structural.bridge;

public class Triangle extends Shape {

	public Triangle(Color color) {
		super(color);
	}

	@Override
	public void applyColor() {
		System.out.println("a triangle fill with color :"+ color.applyColor());
	}

}
