package howto.lambdainterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExtendCollection {

	public static void main(String[] args) {
		Collection2<Integer> numbers = new MyCollection2Impl<>();
		numbers.add(2);
		numbers.add(3);
		numbers.add(5);
		numbers.add(7);
		numbers.add(9);
		numbers.forEachIf(System.out::println, i -> i > 5);
	}
}

class MyCollection2Impl<T> extends ArrayList<T> implements Collection2<T> {
	private static final long serialVersionUID = -1202005142690509313L;
}

interface Collection2<T> extends Collection<T> {
	default void forEachIf(Consumer<T> action, Predicate<T> filter) {
		this.stream().filter(filter).forEach(action);
	}
}