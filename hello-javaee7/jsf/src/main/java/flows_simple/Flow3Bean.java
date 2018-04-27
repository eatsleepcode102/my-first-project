package flows_simple;

import java.io.Serializable;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped("flow3")
public class Flow3Bean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Flow3Bean() {
		System.out.println("Flow3Bean.Constructor");
	}
	
	public String getName() {
		return this.getClass().getSimpleName();
	}
	
	public String getHomeAction() {
		return "/faces/flows_simple";
	}
}
