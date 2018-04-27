package dp.creational.abstract_factory1;

public class TesLaFactory implements AbstractFactory {

	private String maluc;
	private String hdh;
	
	private String hdd;
	private String ram;
	private String res;
	
	public TesLaFactory(String maluc, String hdh) {
		super();
		this.maluc = maluc;
		this.hdh = hdh;
	}
	
	

	public TesLaFactory(String hdd, String ram, String res) {
		super();
		this.hdd = hdd;
		this.ram = ram;
		this.res = res;
	}



	@Override
	public AbstractSmartphone createSmartphone() {
		// TODO Auto-generated method stub
		return new TeslaSmartPhone(hdd, ram, res);
	}

	@Override
	public AbstractSmartWatch createSmartWatch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractLaptop createLaptop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractSelfDriveCar createSelfDriveCar() {
		// TODO Auto-generated method stub
		return new TeslaSelfDriveCar(maluc, hdh);
	}

}
