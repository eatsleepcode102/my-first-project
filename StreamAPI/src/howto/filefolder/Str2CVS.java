package howto.filefolder;

import java.util.ArrayList;
import java.util.List;

public class Str2CVS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> mascots = new ArrayList<>();
		mascots.add("duke");
		mascots.add("juggy");
		mascots.add("ss");

		String actual = mascots.stream().reduce((t, u) -> t + "," + u).get();
		System.out.println(actual);
	}
}
