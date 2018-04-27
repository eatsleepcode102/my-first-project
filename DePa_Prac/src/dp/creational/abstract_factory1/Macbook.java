package dp.creational.abstract_factory1;

public class Macbook extends AbstractLaptop {

	private String hdd;
	private String ram;
	private String res;
	
	
	
	public Macbook(String hdd, String ram, String res) {
		this.hdd = hdd;
		this.ram = ram;
		this.res = res;
	}

	@Override
	String getHDD() {
		// TODO Auto-generated method stub
		return this.hdd;
	}

	@Override
	String getRAM() {
		// TODO Auto-generated method stub
		return this.ram;
	}

	@Override
	String getResolution() {
		// TODO Auto-generated method stub
		return this.res;
	}
}
