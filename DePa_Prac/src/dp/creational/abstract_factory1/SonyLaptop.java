package dp.creational.abstract_factory1;

public class SonyLaptop extends AbstractLaptop{

	private String hdd;
	private String ram;
	private String res;
	
	
	
	public SonyLaptop(String hdd, String ram, String res) {
		this.hdd = hdd;
		this.ram = ram;
		this.res = res;
	}
	
	@Override
	String getHDD() {
		// TODO Auto-generated method stub
		return hdd;
	}

	@Override
	String getRAM() {
		// TODO Auto-generated method stub
		return ram;
	}

	@Override
	String getResolution() {
		// TODO Auto-generated method stub
		return res;
	}

}
