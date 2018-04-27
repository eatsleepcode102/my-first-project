package ajax;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class UserService implements Serializable{

	@Inject
	User user;
	
	public void register() {
//		user.register(event);
		user.setStatus("not using actionListener");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
