package dp.creational.abstract_factory1;

public abstract class AbstractSelfDriveCar {

	abstract String getMaLuc();
	abstract String getHDH();// he dieu hanh

	public String getLabel() {
		return this.getClass().getSimpleName();
	}
	@Override
	public String toString() {
		return "created "+ this.getLabel()+": HDH="+ getHDH()+", MaLuc="+ getMaLuc();
	}
	
}
