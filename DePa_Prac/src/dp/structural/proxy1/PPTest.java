package dp.structural.proxy1;

public class PPTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount a=new BankAccount(333, 9000);
		BankAccount b=new BankAccount(444, 9500);
		
		BankAccountProxy bap=new BankAccountProxy(a, "abc", "123");
		bap.rutTien(5500);
		bap.xemSodu();
		
	}

}
