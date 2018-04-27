package howto.lambdaapi;

import java.util.ArrayList;
import java.util.List;

public class MatchCondition {

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
	    
	    boolean allStartWithA=stringCollection.stream().anyMatch((s)-> s.startsWith("a"));
	    System.out.println(allStartWithA);

	}

}
