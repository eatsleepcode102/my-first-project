package dp.structural.bridge;

public class BridgeTest {
	public static void main(String[] args) {
		Triangle t=new Triangle(new GreenColor());
		t.applyColor();
		
		Rectangle r=new Rectangle(new YellowColor());
		r.applyColor();
		
		new Triangle(new BlueColor()).applyColor();
	}
}
