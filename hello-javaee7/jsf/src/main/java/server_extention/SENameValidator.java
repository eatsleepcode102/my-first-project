package server_extention;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("sENameValidator")
public class SENameValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		System.out.println("Got: "+ value);
		if(((String)value).length()<3) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Incorrect name length",
	                "Name length must >= 3, found only " + value));
		}
	}
}
