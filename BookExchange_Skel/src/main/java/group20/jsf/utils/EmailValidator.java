package group20.jsf.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.*;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;

/*
 * Validates if the e-mail that is entered contains "@"
 *
 * @author Daniel
 */
public class EmailValidator implements Validator {
    
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException{
        
        String email = (String) value;
        
        
        if(!email.contains("@")){
            throw new ValidatorException(new FacesMessage("Email is not valid."));
        }
        
        
    }
}
