package server_extention;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("sEMyConverter")
public class SEMyConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		System.out.println("Received:"+ value);
		try {
		return new SEUserAge(Integer.parseInt(value.trim()));
		} catch(NumberFormatException e) {
			throw new ConverterException(new FacesMessage(e.toString()),e);
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		// TODO Auto-generated method stub
		return String.valueOf(((SEUserAge)value).getAge());
	}

}
