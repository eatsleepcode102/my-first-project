package bean_validator;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named
@SessionScoped
public class MyBeanValidator implements Serializable {
	
	@Size(min=3, message="At least 3 characters")
	private String name;
	@Min(value=10, message="must be greater than or equal to 10")
	@Max(value=20, message="must be less than or equal to 20")
	private int age;
	@Pattern(regexp = "[0-9]{5}", message= "must match \"[0-9]{5}\"")
	private String zip;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
