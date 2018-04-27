package howto.optional;

import java.util.Optional;

public class TryWithSpecificObject {

	public static void main(String[] args) {
		Optional<Emp> emp=Optional.of(new Emp("A","B"));
		emp.ifPresent(System.out::println);
		System.out.println(!emp.isPresent()? emp.get().firstName: "opps! what a null object");
	}

}

class Emp {
	
	String firstName;
	String lastName;

	public Emp(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return firstName;
	}
}