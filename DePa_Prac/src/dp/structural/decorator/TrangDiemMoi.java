package dp.structural.decorator;

public class TrangDiemMoi extends KhuonMatDecorator {

	public TrangDiemMoi(KhuonMat km) {
		super(km);
	}

	@Override
	public void trangdiem() {
		khuonmat.trangdiem();
		System.out.println("trang diem moi");
	}

	
}
