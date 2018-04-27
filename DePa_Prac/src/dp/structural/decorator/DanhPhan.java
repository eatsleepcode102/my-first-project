package dp.structural.decorator;

public class DanhPhan extends KhuonMatDecorator{

	public DanhPhan(KhuonMat km) {
		super(km);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void trangdiem() {
		// TODO Auto-generated method stub
		khuonmat.trangdiem();
		System.out.println("danh phan trang hong");
	}
	
	

}
