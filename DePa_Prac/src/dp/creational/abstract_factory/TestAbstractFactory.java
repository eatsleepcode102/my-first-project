package dp.creational.abstract_factory;

public class TestAbstractFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactoryProducer.getFactory("printer").getPrinter("web").print();
		FactoryProducer.getFactory("shape").getShape("triangle").draw();
	}
}
