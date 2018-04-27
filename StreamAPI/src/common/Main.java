package common;

import java.util.HashMap;
import java.util.Map;

public abstract class Main {

	public static void main(String[] args) {
		System.out.println("we can run main() inside of an abstract class");
		
		String s1 = "abc";
		String s2 = "abc";
		System.out.println("s1 == s2 is:" + "a" == "a");
		
		String s3 = "JournalDev";
		int start = 1;
		char end = 5;
		System.out.println(start + end);
		System.out.println(s3.substring(start, end));
		
		//trying map collection
		Map<String, String> map=new HashMap<>();
		map.put("A", "A");
		map.put("B", "B");
		map.put("A", "B");
		for(String a:map.values().toArray(new String[map.size()])){
			System.out.println(a);
		}
		
	}

}
