package ajax;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class User implements Serializable{
	
	private String name;
	private String password;
	private String status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void register(javax.faces.event.ActionEvent event) {
		if(name.startsWith("syn")) {
			status="Register successfully 2";
		} else {
			status="Register failed 2";
		}
	}
	
	public void login(javax.faces.event.ActionEvent e) {
		if(name.equals(password)) {
			status="Login successfully";
		} else {
			status="login failed";
		}
	}
}
