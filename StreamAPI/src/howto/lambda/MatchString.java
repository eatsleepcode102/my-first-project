package howto.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MatchString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arg=Arrays.asList("help","c");
		
		Predicate<String> isHelp=(s)->s.matches("h|help");
		Predicate<String> isVerbose=(s)->s.matches("v|verbose");
		
		boolean needsHelp=arg.stream().anyMatch(isHelp);
		System.out.println(needsHelp);
		
		boolean verbose = arg.stream().anyMatch(isVerbose);
	    System.out.println(verbose);
	}

}
