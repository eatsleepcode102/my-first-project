package dp.creational.abstract_factory1;

public class SamSungFactory implements AbstractFactory {

	private String hdd;
	private String ram;
	private String res;
	
	
	public SamSungFactory(String hdd, String ram, String resolution) {
		this.hdd = hdd;
		this.ram = ram;
		this.res = resolution;
	}


	@Override
	public AbstractSmartphone createSmartphone() {
		return new SamSungSmartphone(hdd, ram, res);
	}


	@Override
	public AbstractSmartWatch createSmartWatch() {
		return new SamSungSmartWatch(hdd, ram, res);
	}


	@Override
	public AbstractLaptop createLaptop() {
		// TODO Auto-generated method stub
		return new SamSungLaptop(hdd, ram, res);
	}


	@Override
	public AbstractSelfDriveCar createSelfDriveCar() {
		// TODO Auto-generated method stub
		return null;
	}

}
