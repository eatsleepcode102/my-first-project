package dp.structural.proxy1;

public class BankAccountProxy implements IBankAccount{

	private boolean isAdmin;
	private BankAccount ba;
	
	public BankAccountProxy(BankAccount ba,String user, String pwd) {
		if("abc".equals(user) && "123".equals(pwd)) {
			isAdmin=true;
		}
		this.ba=ba;
	}

	@Override
	public void chuyenTien(IBankAccount toAcc, double soTien) {
		if(isAdmin) {
			ba.chuyenTien(toAcc, soTien);
		} else {
			System.out.println("[failed] you're not admin user");
		}
	}

	@Override
	public void rutTien(double soTien) {
		if(isAdmin) {
			if(soTien> 5000) {
				System.out.println("[failed] your amount is too much");
			} else {
			ba.rutTien(soTien);
			}
		} else {
			System.out.println("[failed] you're not admin user");
		}
	}

	@Override
	public void xemSodu() {
		ba.xemSodu();
	}

	@Override
	public double getSodu() {
		return ba.getSodu();
	}

	@Override
	public void setSodu(double d) {
		ba.setSodu(d);
	}
	
}
