package dp.structural.bridge;

public class Rectangle extends Shape {

	public Rectangle(Color color) {
		super(color);
	}

	@Override
	public void applyColor() {
		System.out.println("a rectangle is filled with color:"+ color.applyColor());
	}
}
