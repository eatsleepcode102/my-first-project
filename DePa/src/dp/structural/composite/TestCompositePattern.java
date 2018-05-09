package dp.structural.composite;

public class TestCompositePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape tri=new Triangle();
		Shape tri1=new Triangle();
		Shape cir=new Circle();
		Drawing drawing =new Drawing();
		drawing.add(tri1);
		drawing.add(tri);
		drawing.add(cir);
		drawing.draw("RED");
		drawing.clear();
		drawing.add(tri);
		drawing.add(cir);
		drawing.draw("BLUE");
	}
}
