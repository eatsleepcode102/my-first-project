package dp.creational.factory;

/*
 * Factory Pattern
 * factory pattern is used when we have a super class with multiple subclasses and based on input.
 * we need to return one of the subclass
 * 
 * # benefits of factory pattern:
 * - provides approach to code for interface rather than implementation
 * - removes the instantiation of actual implementation classes from client code, making it more robust
 * 	less coupled and easy to extend
 * 		ex: we can easily change PC class implementation because client program(main() method) is unaware of this
 * */

public class TestFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer pc=ComputerFactory.getComputer("pc", "2 GB", "500", "2.4 GHZ");
		Computer server=ComputerFactory.getComputer("server", "6 GB", "1024 GB", "3.7 GHZ");
		
		System.out.println("Factory PC config: "+pc);
		System.out.println("Factory Server config: "+server);
	}
}

