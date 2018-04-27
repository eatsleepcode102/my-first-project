package dp.creational.abstract_factory1;

public class TeslaSelfDriveCar extends AbstractSelfDriveCar {

	private String maluc;
	private String hdh;
	
	public TeslaSelfDriveCar(String maluc, String hdh) {
		super();
		this.maluc = maluc;
		this.hdh = hdh;
	}

	@Override
	String getMaLuc() {
		// TODO Auto-generated method stub
		return maluc;
	}

	@Override
	String getHDH() {
		// TODO Auto-generated method stub
		return hdh;
	}

}
