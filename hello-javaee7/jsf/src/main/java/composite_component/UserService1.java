package composite_component;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class UserService1 implements Serializable{

	@Inject
	User1 user1;
	
	public void register() {
        System.out.println("Registering " + user1.getName() + " with the password \"" + user1.getPassword() + "\"");
	}
}
