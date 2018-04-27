package howto.lambdainterface;

public class AssignMethodToFunc {

	public static void main(String[] args) {
		// we would like to know how to assign a method from java build-in class to a functional interface
		Converter<String, Integer> con=Integer::valueOf;
		System.out.println(con.convert("123"));
		//we would like to know how to assign your own method to a functional interface
		Converter<String, String> sCon=Something::startWith;
		System.out.println(sCon.convert("Java"));
		
	}
}

class Something {
	static String startWith(String s) {
		return String.valueOf(s.charAt(0));
	}
}

interface Converter<From, To>{
	To convert(From f);
}