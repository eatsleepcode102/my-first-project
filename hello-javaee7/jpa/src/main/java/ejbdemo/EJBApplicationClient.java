package ejbdemo;

import javax.naming.Context;
import javax.naming.NamingException;

public class EJBApplicationClient {
	
	public static void main(String[] args) {
		Hello bean = doLookup();
		System.out.println(bean.sayHello()); // 4. Call business logic
	}

	private static Hello doLookup() {
		Context context = null;
		Hello bean = null;
		try {
			// 1. Obtaining Context
			context = ClientUtility.getInitialContext();
			// 2. Generate JNDI Lookup name
			String lookupName =getLookupName();
			// 3. Lookup and cast
			bean = (Hello) context.lookup(lookupName);

		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}

	private static String getLookupName() {
/* 
The app name is the EAR name of the deployed EJB without .ear suffix. 
Since we haven't deployed the application as a .ear, 
the app name for us will be an empty string
*/
		String appName = "";

		/* The module name is the JAR name of the deployed EJB 
        without the .jar suffix.
		*/
		String moduleName = "HelloWorldSessionBean";

/*AS7 allows each deployment to have an (optional) distinct name. 
This can be an empty string if distinct name is not specified.
*/
		String distinctName = "";

		// The EJB bean implementation class name
		String beanName = HelloBean.class.getSimpleName();

		// Fully qualified remote interface name
		final String interfaceName = Hello.class.getName();

		// Create a look up string name
//		String name = "ejb:" + appName + "/" + moduleName + "/" + 
//			distinctName 	+ "/" + beanName + "!" + interfaceName;
		String name="ejb:/jpa-0.0.1-SNAPSHOT/HelloBean!ejbdemo.Hello";
		return name;
	}
}