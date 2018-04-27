package howto.list;

import java.util.stream.Stream;

public class UseIterare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long l=Stream.iterate(1L, i-> i+2).limit(4).reduce(Long::sum).get();
		System.out.println(l);
	}
}
