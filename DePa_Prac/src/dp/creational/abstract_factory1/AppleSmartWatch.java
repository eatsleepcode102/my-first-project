package dp.creational.abstract_factory1;

public class AppleSmartWatch extends AbstractSmartWatch{

	private String hdd;
	private String ram;
	private String res;
	
	public AppleSmartWatch(String hdd, String ram, String res) {
		this.hdd = hdd;
		this.ram = ram;
		this.res = res;
	}
	
	
	@Override
	String getHDD() {
		return this.hdd;
	}

	@Override
	String getRAM() {
		return this.ram;
	}

	@Override
	String getResolution() {
		return this.res;
	}

}
