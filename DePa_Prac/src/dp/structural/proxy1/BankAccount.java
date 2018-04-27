package dp.structural.proxy1;

public class BankAccount implements IBankAccount{
	
	private int sotk;
	private double sodu;
	
	public BankAccount(int sotk, double sodu) {
		this.sotk = sotk;
		this.sodu = sodu;
	}

	public double getSodu() {
		return sodu;
	}

	public void setSodu(double sodu) {
		this.sodu = sodu;
	}
	
	public int getSotk() {
		return sotk;
	}

	public void setSotk(int sotk) {
		this.sotk = sotk;
	}

	@Override
	public void chuyenTien(IBankAccount toAcc, double soTien) {
		toAcc.setSodu(toAcc.getSodu() + soTien);
		this.setSodu(this.getSodu() - soTien);
		System.out.println("Giao dich thanh cong");
		System.out.println(this);
		System.out.println(toAcc);
	}
	
	@Override
	public void rutTien(double soTien) {
		this.setSodu(this.getSodu() - soTien);
		System.out.println("rut tien thanh cong");
		System.out.println(this);
	}
	
	@Override
	public void xemSodu() {
		System.out.println("xem info");
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "\nInfo: soTk="+ getSotk()+", sodu="+getSodu();
	}
}
