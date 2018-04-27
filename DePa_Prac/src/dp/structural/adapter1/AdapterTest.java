package dp.structural.adapter1;

public class AdapterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPlayer mp=new MyPlayer();
		mp.play(FileType.AVI);
		
		//practice enum java
		  System.out.println(WhoisRIR.ARIN.getUrl());
		  System.out.println(WhoisRIR.ARIN.containNet());
		  
		  System.out.println(Week.Mon.getInfo()[0]);
	}
}


