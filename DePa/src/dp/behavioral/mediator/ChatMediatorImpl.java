package dp.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {

	private List<User> users;
	
	public ChatMediatorImpl() {
		// TODO Auto-generated constructor stub
		this.users=new ArrayList();
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.users.add(user);
	}

	@Override
	public void sendMessage(String msg, User user) {
		// TODO Auto-generated method stub
		for(User u: this.users) {
			if(u!=user) {
				u.receive(msg);
			}
		}
	}
}
