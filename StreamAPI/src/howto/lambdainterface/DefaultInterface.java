package howto.lambdainterface;

public class DefaultInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildInterface chi=(s)-> System.out.println("Likeit method:"+ s);
		chi.doIt();
		chi.likeIt("Java eight");
	}
}


interface ChildInterface extends ParentInterface {
	public default void doIt() {
		System.out.println("my extended doIt function");
	}
}

interface ParentInterface {
	public void likeIt(String s);
	public default void doIt() {
		System.out.println("doIt function..");
	}
}