package criteria;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Movie;


public class CriteriaMain {

	private static Context context;

	public static void main(String[] args) throws NamingException {
		if(context==null) {
		Properties properties=new Properties();
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8084");
		context=new InitialContext(properties);
		}
		MovieBeanRemote bean=(MovieBeanRemote) context.lookup("ejb:/jpa-0.0.1-SNAPSHOT/MovieBean!criteria.MovieBeanRemote");
		//after having MovieBeanRemote
//		bean.updateMovie();
		for(Movie m: bean.listMovies()) {
			System.out.println(m.getId() +"-"+m.getName());
		}
		context.close();
	}
}
