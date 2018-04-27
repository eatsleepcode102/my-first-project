package dp.structural.proxy1;

public interface IBankAccount {

	void chuyenTien(IBankAccount toAcc, double soTien);
	void rutTien(double soTien);
	void xemSodu();
	double getSodu();
	void setSodu(double d);
	
}
