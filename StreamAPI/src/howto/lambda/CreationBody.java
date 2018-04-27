package howto.lambda;

public class CreationBody {

	public static void main(String[] args) {
		// no need () and return
		MyCalculator myCalculator = (s1) -> s1 * 2;
		System.out.println("1- Result x2 : " + myCalculator.calcIt(5));

		// need {} and return and ;

		myCalculator = (Integer s1) -> {
			return s1 * 2;
		};
		System.out.println("3- Result x2 : " + myCalculator.calcIt(6));
	}
}

interface MyCalculator {
	public Integer calcIt(Integer s1);
}
