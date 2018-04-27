package me.samples.cdi;

import javax.enterprise.context.RequestScoped;

import me.samples.cdi.GreetingType.ServiceType;

@RequestScoped
@GreetingType(ServiceType.Simple)
public class SimpleGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Complain: " + name;
    }
}
