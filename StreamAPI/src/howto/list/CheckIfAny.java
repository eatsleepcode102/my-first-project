package howto.list;

import java.util.ArrayList;
import java.util.List;

public class CheckIfAny {

	public static void main(String[] args) {
		List<String> stringCollection = new ArrayList<>();
	    stringCollection.add("ddd2");
	    stringCollection.add("aaa2");
	    stringCollection.add("bbb1");
	    stringCollection.add("aaa1");
	    stringCollection.add("bbb3");
	    stringCollection.add("ccc");
	    stringCollection.add("bbb2");
	    stringCollection.add("ddd1");
	    boolean anyStartWithA=stringCollection.stream().anyMatch(s -> s.startsWith("a"));
	    boolean noneStartWithz=stringCollection.stream().anyMatch(s -> s.startsWith("z"));
	    System.out.println("Check if any string in the list matches the condition:"+anyStartWithA);
	    System.out.println("Check if none string in the list matches the condition:"+ noneStartWithz);

	}

}
