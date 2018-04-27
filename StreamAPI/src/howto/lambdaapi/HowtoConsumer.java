package howto.lambdaapi;

import java.util.function.Consumer;

public class HowtoConsumer {

	public static void main(String[] args) {
		Consumer<String> msgConsumer=(t)-> System.out.println(t);
		Consumer<String> endConsumer=(t)-> System.out.println("end:"+t);
		msgConsumer.andThen(endConsumer).accept("Jame");
		
		sayBrand(e-> System.out.println("Car's Brand:"+ e));
	}
	
	public static void sayBrand(Consumer<String> block) {
		block.accept("Audio A6");
	}
}
