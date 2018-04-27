package dp.structural.decorator;

public class KhuonMatDecorator implements KhuonMat {

	protected KhuonMat khuonmat;// need a face for making up
	
	
	
	public KhuonMatDecorator(KhuonMat km) {
		this.khuonmat=km;// get from child
	}



	@Override
	public void trangdiem() {
		// TODO Auto-generated method stub
		this.khuonmat.trangdiem();
	}

}
