package dp.behavioral.template;

public abstract class HouseTemplate {
	
	//template method, final so subclasses can't override
	//note: subclasses don't override the template method, we should make it final
	public final void buildHouse() {
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built");
	}


	private void buildFoundation() {
		// TODO Auto-generated method stub
		System.out.println("Building foundation with cement, iron rods, and sands");
	}
	
	//methods to be implemented by subclasses
	//note: it is public for subclasses performing implementation
	public abstract void buildWalls();
	public abstract void buildPillars();
	
	// default Implementation
	private void buildWindows() {
		// TODO Auto-generated method stub
		System.out.println("Building Glass Windows");
	}
	
}
