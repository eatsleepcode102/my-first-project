package howto.lambdainterface;

public class ConstructorRef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentConstructor<Student> personFactory = Student::new;
		System.out.println(personFactory.create("Forst", "Last"));
	}
}

interface StudentConstructor<P extends Student> {
	P create(String firstname, String lastName);
}

class Student {
	String firstName;
	String lastName;

	Student() {
	}

	Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return firstName;
	}
}