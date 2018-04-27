package dp.creational.abstract_factory;

public class ConsolePrinter implements Printer{

	@Override
	public void print() {
		System.out.println("ConsolePrinter::print()");
	}

}
