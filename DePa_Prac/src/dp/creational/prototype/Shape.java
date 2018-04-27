package dp.creational.prototype;

public abstract class Shape implements Cloneable{

	private int id;
	private String type;
	
	abstract void draw();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Circle: id="+ id +", type="+ type;
	}
	
}
