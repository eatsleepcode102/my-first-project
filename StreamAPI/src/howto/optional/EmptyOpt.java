package howto.optional;

import java.util.Optional;

/**
 * create_instance
 * example
 * @param array of attributes for instance containing web, db, arrival_rate, response_time for instance 
 * respectively.
 * @return Instance object
 */
public class EmptyOpt {
	/**
	 * this is entry point of this programming
	 * @author Coder
	 * @exception
	 *  throw an exception
	 * @param
	 * a String arrays
	 * 
	 * @return
	 * null
	 * */
	public static void main(String[] args) {
		Optional<Integer> value=Optional.empty();
		System.out.println(value.orElse(42));
		System.out.println(value.isPresent());
		System.out.println(value.get());
	}
}
