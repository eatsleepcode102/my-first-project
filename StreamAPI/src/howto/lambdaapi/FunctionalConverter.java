package howto.lambdaapi;

public class FunctionalConverter {

	public static void main(String[] args) {
		Converter<String, Integer> con=(t) -> Integer.valueOf(t);
		System.out.println(con.convert("123") + 1);
	}
}

interface Converter<From, To>{
	To convert(From f);
}