package dp.creational.abstract_factory1;

public class SamSungSmartphone extends AbstractSmartphone {

	private String hdd;
	private String ram;
	private String res;
	
	
	
	public SamSungSmartphone(String hdd, String ram, String res) {
		super();
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
