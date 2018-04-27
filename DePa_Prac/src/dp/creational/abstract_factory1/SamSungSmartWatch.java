package dp.creational.abstract_factory1;

public class SamSungSmartWatch extends AbstractSmartWatch {

	private String hdd;
	private String ram;
	private String res;
	
	
	
	public SamSungSmartWatch(String hdd, String ram, String res) {
		super();
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
