package ejbdemo;

import javax.ejb.Stateless;

@Stateless
public class HelloBean implements Hello {
 
    public HelloBean() {
 
    }
 
    public String sayHello() {
 
        return "Hello Boss Welcome to EJB";
    }
 
}