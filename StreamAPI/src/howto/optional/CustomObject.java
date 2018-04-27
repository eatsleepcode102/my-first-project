package howto.optional;

import java.util.Optional;

public class CustomObject {

	public static void main(String[] args) {
		// we would like to know how to create Optional custom Object value;
		Optional.of(new Outer())
		.flatMap(o-> Optional.ofNullable(o.nested))
		.flatMap(n-> Optional.ofNullable(n.inner))
		.flatMap(i-> Optional.ofNullable(i.foo))
		.ifPresent(System.out::println);
		
		Optional value=Optional.of(null);
		System.out.println(value.get());
	}
	
	static class Outer {
		Nested nested;
	}
	
	static class Nested {
		Inner inner;
	}
	
	static class Inner {
		String foo;
	}
}
