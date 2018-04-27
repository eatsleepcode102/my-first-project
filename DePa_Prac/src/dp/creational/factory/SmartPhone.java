package dp.creational.factory;

public abstract class SmartPhone {
	
	abstract String getType();
	abstract String getResolution();
	abstract String getRam();
	
	@Override
	public String toString() {
		return "SmartPhone: Type="+ this.getType()+", Resolution= "+ this.getResolution()+ ", CPU"+ this.getRam();
	}
	
}
