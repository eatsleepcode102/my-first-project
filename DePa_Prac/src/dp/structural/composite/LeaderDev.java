package dp.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class LeaderDev implements Developer {

	List<Developer> devs = new ArrayList<>();

	@Override
	public void doCoding() {
		for (Developer dev : devs) {
			dev.doCoding();
		}
	}

	public void add(Developer d) {
		devs.add(d);
	}

	public void remove(Developer d) {
		devs.remove(d);
	}

	public void clear() {
		System.out.println("all you're fired");
		devs.clear();
	}
}
