package dp.creational.builder;

public class TestBuilderPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer comp=new Computer.ComputerBuilder("500 GB", "2GB").setBluetoothEnabled(true).setGraphicsCardEnabled(true).build();
		System.out.println(comp.toString());
	}
}
