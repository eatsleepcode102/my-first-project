package dp.creational.abstract_factory1;

public abstract class AbstractLaptop {
	
	abstract String getHDD();
	abstract String getRAM();
	abstract String getResolution();
	public String getLabel() {
		return this.getClass().getSimpleName();
	}
	
	@Override
	public String toString() {
		return "Created "+getLabel()+": HDD="+ getHDD()+", RAM="+ getRAM()+", Resolution="+ getResolution();
	}
}
