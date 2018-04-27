package dp.creational.abstract_factory;

public class PrinterFactory implements AbstractFactory {

	@Override
	public Printer getPrinter(String printerType) {
		if(printerType.equalsIgnoreCase("web")) {
			return new WebPrinter();
		} else if(printerType.equalsIgnoreCase("console")) {
			return new ConsolePrinter();
		} else {
			return null;
		}
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
