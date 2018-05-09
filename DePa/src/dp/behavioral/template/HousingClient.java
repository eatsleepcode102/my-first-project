package dp.behavioral.template;

public class HousingClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseTemplate houseType=new WoodenHouse();
		houseType.buildHouse();
		
		System.out.println("****");
		
		houseType=new GlassHouse();
		houseType.buildHouse();
	}

}
