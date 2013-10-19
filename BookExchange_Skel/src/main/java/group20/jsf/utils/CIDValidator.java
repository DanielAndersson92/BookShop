/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.utils;

import group20.bookexchange.core.BookExchange;
import group20.bookexchange.core.User;
import group20.jsf.mb.ExchangeBean;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.persistence.RollbackException;

/**
 *
 * @author Daniel
 */
public class CIDValidator implements Validator {
    
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    
    @Inject
    public ExchangeBean exchangeBean;
    
    private Boolean CIDExists(String cid){
       
        return exchangeBean.getUserRegistry().checkCID(cid);
    }
    
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException{
        
        String cid = (String) value;
        LOGGER.info("Fuck this " + cid);
        LOGGER.info("Fuck this " + exchangeBean.toString());
        
        if(CIDExists(cid)){
            throw new ValidatorException(new FacesMessage("CID already in use."));
        }
    }
}
