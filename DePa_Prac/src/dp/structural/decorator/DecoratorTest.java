package dp.structural.decorator;

public class DecoratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KhuonMat khuonmatxinh=new TrangDiemMui(new TrangDiemMoi(new DanhPhan(new MatMoc())));
		khuonmatxinh.trangdiem();
	}

}
