package dp.behavioral.chain;

public class Dollar50Dispenser implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency sur) {
		// TODO Auto-generated method stub
		if (sur.getAmount() >= 50) {
			int num = sur.getAmount() / 50;
			int remainder = sur.getAmount() % 50;
			System.out.println("Dispensing +" + num + " 50$ note");
			if (remainder != 0) {
				this.chain.dispense(new Currency(remainder));
			}
		} else {
			this.chain.dispense(sur);
		}
	}

}
