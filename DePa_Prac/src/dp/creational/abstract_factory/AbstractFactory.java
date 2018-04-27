package dp.creational.abstract_factory;

public interface AbstractFactory {
	public Printer getPrinter(String printerType);
	public Shape getShape(String shapeType);
}
