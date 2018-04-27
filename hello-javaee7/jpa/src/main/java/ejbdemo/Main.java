package ejbdemo;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Hello From Java!");
			Properties props = new Properties();
			props.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
			props.setProperty(Context.PROVIDER_URL,"tcp://localhost:8084");
			InitialContext context = new InitialContext(props);

			String appName = "";
			String moduleName = "jpa-0.0.1-SNAPSHOT";
			String distinctName = "";
			String beanName = HelloBean.class.getSimpleName();
			String interfaceName = Hello.class.getName();
			String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!"
					+ interfaceName;
			System.out.println(name);
			Hello bean = (Hello) context.lookup(name);
			String result = bean.sayHello();
			System.out.println("Result computed by EJB is :" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
