package dp.structural.composite;

public class SeniorDev implements Developer{

	@Override
	public void doCoding() {
		System.out.println("an instance of "+this.getClass().getSimpleName()+" is coding");
	}

}
