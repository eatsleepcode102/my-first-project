package dp.creational.abstract_factory1;

public class AppleFactory implements AbstractFactory{

	
	private String hdd;
	private String ram;
	private String res;
	
	public AppleFactory(String hdd, String ram, String resolution) {
		this.hdd = hdd;
		this.ram = ram;
		this.res = resolution;
	}


	@Override
	public AbstractSmartphone createSmartphone() {
		// TODO Auto-generated method stub
		return new IPhone(hdd, ram, res);
	}


	@Override
	public AbstractSmartWatch createSmartWatch() {
		// TODO Auto-generated method stub
		return new AppleSmartWatch(hdd, ram, res);
	}


	@Override
	public AbstractLaptop createLaptop() {
		// TODO Auto-generated method stub
		return new Macbook(hdd, ram, res);
	}


	@Override
	public AbstractSelfDriveCar createSelfDriveCar() {
		// TODO Auto-generated method stub
		return null;
	}


}
