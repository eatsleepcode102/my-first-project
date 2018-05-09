package dp.behavioral.state;

public class TVContext implements State{

	private State tvState;
	
	
	public State getTvState() {
		return tvState;
	}


	public void setTvState(State tvState) {
		this.tvState = tvState;
	}


	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		this.tvState.doAction();
	}

}
