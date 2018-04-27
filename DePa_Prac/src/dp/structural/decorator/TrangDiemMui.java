package dp.structural.decorator;

public class TrangDiemMui extends KhuonMatDecorator{

	public TrangDiemMui(KhuonMat km) {
		super(km);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void trangdiem() {
		// TODO Auto-generated method stub
		khuonmat.trangdiem();
		System.out.println("lam mui cao");
	}
}
