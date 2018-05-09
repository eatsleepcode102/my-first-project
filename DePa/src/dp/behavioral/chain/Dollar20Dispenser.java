package dp.behavioral.chain;

public class Dollar20Dispenser implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		// TODO Auto-generated method stub
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency sur) {
		// TODO Auto-generated method stub
		if (sur.getAmount() >= 20) {
			int num = sur.getAmount() / 20;
			int remainder = sur.getAmount() % 20;
			System.out.println("Dispensing +" + num + " 20$ note");
			if (remainder != 0) {
				this.chain.dispense(new Currency(remainder));
			}
		} else {
			this.chain.dispense(sur);
		}
	}

}
