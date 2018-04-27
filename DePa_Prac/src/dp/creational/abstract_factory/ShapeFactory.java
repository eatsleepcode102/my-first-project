package dp.creational.abstract_factory;

public class ShapeFactory implements AbstractFactory {

	@Override
	public Printer getPrinter(String printerType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape getShape(String shapeType) {
		if(shapeType.equalsIgnoreCase("rectangle")) {
			return new Rectangle();
		} else if(shapeType.equalsIgnoreCase("triangle")) {
			return new Triangle();
		} else {
			return null;
		}
	}

}
