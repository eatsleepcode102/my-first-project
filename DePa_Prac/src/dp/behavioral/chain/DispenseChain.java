package dp.behavioral.chain;

public interface DispenseChain {

	void setNextChain(DispenseChain next);
	void dispense(Currency cur);
}
