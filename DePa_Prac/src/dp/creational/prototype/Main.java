package dp.creational.prototype;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Circle c=new Circle();
		c.setId(1);
		c.setType("none");
		System.out.println(c);
		Circle c1=(Circle) c.clone();
		System.out.println(c1);
		c1.setId(2);
		System.out.println(c1);
	}

}
