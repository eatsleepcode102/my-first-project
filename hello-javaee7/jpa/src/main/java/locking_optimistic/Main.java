package locking_optimistic;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Movie1;

public class Main {

	private static Context context;

	public static void main(String[] args) throws NamingException {
		if(context==null) {
		Properties properties=new Properties();
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8090");
		context=new InitialContext(properties);
		}
		MovieBeanOpRemote bean=(MovieBeanOpRemote) context.lookup("ejb:/jpa-0.0.1-SNAPSHOT/MovieBeanOp!locking_optimistic.MovieBeanOpRemote");
		bean.updateMovie(1, "AAA");
		Movie1 m=bean.readMovie(1);
		bean.updateMovie(m, "CC");
		context.close();
		
	}

}
