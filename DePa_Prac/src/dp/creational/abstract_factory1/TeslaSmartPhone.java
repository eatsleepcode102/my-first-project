package dp.creational.abstract_factory1;

public class TeslaSmartPhone extends AbstractSmartphone {

	private String hdd;
	private String ram;
	private String res;
	
	
	
	public TeslaSmartPhone(String hdd, String ram, String res) {
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
		return ram	;
	}

	@Override
	String getResolution() {
		// TODO Auto-generated method stub
		return res;
	}

}
