package dp.creational.abstract_factory;

/*
 * Benefits of Abstract Factory
 * - provides approach to code for interface rather than implementation
 * - be factory of factories and can be easily extended to accommodate more products
 * 		ex: we can add another sub-class Laptop and a factory LaptopFactory
 * - be robust and avoid conditional logic of factory pattern
 * */
public class TestDesignPatterns {

	public static void main(String[] args) {
		testAbstractFactory();
	}
	
	private static void testAbstractFactory() {
		Computer pc=ComputerFactory.getComputer(new PCFactory("2 GB", "500", "2.4 GHZ"));
		Computer server=ComputerFactory.getComputer(new ServerFactory("3 GB", "1024", "4.4 GHZ"));
		
		System.out.println("AbstractFactory PC Config:"+ pc);
		System.out.println("AbstractFactory Server Config:"+ server);
	}
}
