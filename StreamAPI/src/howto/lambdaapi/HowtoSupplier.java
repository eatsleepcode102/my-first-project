package howto.lambdaapi;

import java.util.Objects;
import java.util.function.Supplier;

public class HowtoSupplier {

	public static void main(String[] args) {
		My p1=produce();
		My p2=produce();
		
		System.out.println("Check the same object:?"+ Objects.equals(p1, p2));

	}
	
	public static My produce() {
		Supplier<My> supp=()-> new My();
		return supp.get();
	}

}

class My {
	public My() {
		System.out.println("Sun power initialized");
	}
}
