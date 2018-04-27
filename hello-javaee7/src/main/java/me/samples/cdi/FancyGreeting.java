package me.samples.cdi;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;

import me.samples.cdi.GreetingType.ServiceType;

@RequestScoped
@GreetingType(ServiceType.Fancy)
public class FancyGreeting implements Greeting {

	@Override
	public String greet(String name) {
		// TODO Auto-generated method stub
		return "Complex: " + name;
	}

}
