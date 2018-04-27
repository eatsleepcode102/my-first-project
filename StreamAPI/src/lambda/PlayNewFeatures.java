package lambda;

public class PlayNewFeatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Drawable d=()-> {
			return "drawing";
		};
		
		System.out.println(d.draw());
	}
}

@FunctionalInterface
interface Drawable{
	public String draw();
} 