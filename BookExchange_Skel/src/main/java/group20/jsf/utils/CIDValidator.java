package group20.jsf.utils;

import group20.jsf.cb.RegisterCB;
import group20.jsf.mb.ExchangeBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

/*
 * Validates if an enterd cid is already stored in the database
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
