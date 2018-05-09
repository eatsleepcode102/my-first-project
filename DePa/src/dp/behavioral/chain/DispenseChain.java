package dp.behavioral.chain;

public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);
	void dispense(Currency sur);
}
