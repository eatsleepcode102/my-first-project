package dp.behavioral.nullobject;

public class Programmer extends AbstractEmployee {

	
	public Programmer(String name) {
		this.name=name;
	}

	@Override
	public boolean isNull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
