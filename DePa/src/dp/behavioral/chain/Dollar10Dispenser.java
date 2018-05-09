package dp.behavioral.chain;

public class Dollar10Dispenser implements DispenseChain{

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		// TODO Auto-generated method stub
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency sur) {
		// TODO Auto-generated method stub
		if(sur.getAmount() >= 10) {
			int num=sur.getAmount()/10;
			int remainder=sur.getAmount()% 10;
			System.out.println("Dispensing +"+num+" 10$ note");
			if(remainder !=0) {
				this.chain.dispense(new Currency(remainder));
			} 
		}else {
			this.chain.dispense(sur);
		}
	}

}
