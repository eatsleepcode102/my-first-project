package howto.lambdainterface;

import java.util.stream.IntStream;

public class SaveCal {

	public static void main(String[] args) {
		// we would to know how to use class field variable to save calculation for a method reference
		Accumulator accumulator=new Accumulator();
		IntStream.rangeClosed(1, 100).forEach(accumulator::add); //here the result will be saved into class field variable accumulator
		System.out.println(accumulator.total);
	}
}

class Accumulator {
	int total;
	
	public void add(int value){
		total+=value;
	}
}