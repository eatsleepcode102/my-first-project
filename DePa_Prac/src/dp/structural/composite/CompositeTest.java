package dp.structural.composite;

public class CompositeTest {

	public static void main(String[] args) {
		Developer ju=new JuniorDev();
		Developer se=new SeniorDev();
		LeaderDev le=new LeaderDev();
		
		le.add(ju);
		le.add(se);
		le.doCoding();

	}

}
