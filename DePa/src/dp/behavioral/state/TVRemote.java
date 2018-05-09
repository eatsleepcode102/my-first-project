package dp.behavioral.state;

public class TVRemote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TVContext context=new TVContext();
		State tvStartState=new TVStartState();
		State tvStopState=new TVStopState();
		context.setTvState(tvStartState);
		context.doAction();
		
		context.setTvState(tvStopState);
		context.doAction();
	}

}
