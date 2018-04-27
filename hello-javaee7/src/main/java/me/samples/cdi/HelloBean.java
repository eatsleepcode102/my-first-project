package me.samples.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

import me.samples.cdi.GreetingType.ServiceType;

@Named
@ApplicationScoped
public class HelloBean {

	@Inject 
	@GreetingType(ServiceType.Fancy)
    Greeting greeting;
	// greeting instance must be born before helloBean
	//if HelloBean is annotated with requestScoped then greeting must be requestScope or greater than requestscoped
	
	private String sayHello;

	public String getSayHello() {
		return sayHello=greeting.greet("why we need to mark the greeting class with RequestScoped");
	}

	public void setSayHello(String sayHello) {
		this.sayHello = sayHello;
	}
	
	
}
