package dp.behavioral.mediator;

public class UserImpl extends User {

	public UserImpl(ChatMediator med, String name) {
		super(med, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub
		System.out.println(this.name+": Sending Message="+ msg);
		mediator.sendMessage(msg, this);
	}

	@Override
	public void receive(String msg) {
		// TODO Auto-generated method stub
		System.out.println(this.name+": Received Messge:"+ msg);
	}

}
