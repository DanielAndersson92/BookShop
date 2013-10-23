package group20.jsf.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/*
 * Validates that the entered "password" and "confirmed password" is the same
 *
 * @author Daniel
 */
public class PasswordValidator implements Validator {
    
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException{
        
        String password = (String) value;
        
        UIInput confirmComponent = (UIInput) component.getAttributes().get("confirm");
        String confirm = (String) confirmComponent.getSubmittedValue();
        
        if(!password.equals(confirm)){
            confirmComponent.setValid(false);
            throw new ValidatorException(new FacesMessage("Passwords are not equal."));
        }
        
        
    }
}
