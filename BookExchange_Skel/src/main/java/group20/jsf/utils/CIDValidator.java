/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.utils;

import group20.bookexchange.core.BookExchange;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Daniel
 */
public class CIDValidator implements Validator {
    
    public BookExchange bookExchange;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException{
        
        String cid = (String) value;
        
        
        try{
            bookExchange.getUserRegistry().getByCID(cid);
            throw new ValidatorException(new FacesMessage("CID already in use."));
        }
        catch(NullPointerException e){
            //Okej should be here if everything is OK.
        }
    }
}
