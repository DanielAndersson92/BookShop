/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.utils;

import group20.bookexchange.core.BookExchange;
import group20.bookexchange.core.User;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.persistence.RollbackException;

/**
 *
 * @author Daniel
 */
public class CIDValidator implements Validator {
    
    public BookExchange bookExchange;
    
    private Boolean CIDExists(String cid){
       
        return bookExchange.getUserRegistry().checkCID(cid);
    }
    
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException{
        
        String cid = (String) value;
        
        if(CIDExists(cid)){
            System.out.println(" if <------------------------------------------------------------------------------------------------------------------------------------------------");
            throw new ValidatorException(new FacesMessage("CID already in use."));
        }
    }
}
