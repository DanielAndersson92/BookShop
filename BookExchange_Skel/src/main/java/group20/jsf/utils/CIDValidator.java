/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.utils;

import group20.jsf.cb.RegisterCB;
import group20.jsf.mb.ExchangeBean;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

/**
 *
 * @author Daniel
 */
public class CIDValidator implements Validator {
    
    @Inject
    public ExchangeBean exchangeBean;
    
    public RegisterCB register;
    
    private Boolean CIDExists(String cid){
        Boolean b = false;
        try{
        b = exchangeBean.getUserRegistry().checkCID(cid);
        }
        catch(NullPointerException e){
            
        }
        return b;
    }
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException{
        
        String cid = (String) value;
        
        if(CIDExists(cid)){
            throw new ValidatorException(new FacesMessage("CID already in use."));
        }
    }
}
