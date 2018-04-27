package dp.creational.factory;

public class SamSung extends SmartPhone {

	private String type;
	private String resolution;
	private String ram;
	
	
	public SamSung(String type, String resolution, String ram) {
		super();
		this.type = type;
		this.resolution = resolution;
		this.ram = ram;
	}

	@Override
	String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	String getResolution() {
		// TODO Auto-generated method stub
		return this.resolution;
	}

	@Override
	String getRam() {
		// TODO Auto-generated method stub
		return this.ram;
	}

}
