package dp.creational.abstract_factory1;

public class SonyFactory implements AbstractFactory{

	private String hdd;
	private String ram;
	private String res;
	
	
	public SonyFactory(String hdd, String ram, String resolution) { //like materials for factory
		this.hdd = hdd;
		this.ram = ram;
		this.res = resolution;
	}
	
	@Override
	public AbstractSmartphone createSmartphone() {
		// TODO Auto-generated method stub
		return new SonySmartPhone(hdd, ram, res);
	}

	@Override
	public AbstractSmartWatch createSmartWatch() {
		// TODO Auto-generated method stub
		return new SonySmartWatch(hdd, ram, res);
	}

	@Override
	public AbstractLaptop createLaptop() {
		// TODO Auto-generated method stub
		return new SonyLaptop(hdd, ram, res);
	}

	@Override
	public AbstractSelfDriveCar createSelfDriveCar() {
		// TODO Auto-generated method stub
		return null;
	}

}
