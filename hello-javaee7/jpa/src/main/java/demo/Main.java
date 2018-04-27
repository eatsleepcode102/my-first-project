package demo;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejbdemo.Hello;

public class Main {
	
	private static Context context;

	public static void main(String[] args) throws NamingException {
		if(context==null) {
		Properties properties=new Properties();
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8090");
		context=new InitialContext(properties);
		}
		Hello bean=(Hello) context.lookup("ejb:/jpa-0.0.1-SNAPSHOT/HelloBean!ejbdemo.Hello");
		System.out.println(bean.sayHello());
	}
}
