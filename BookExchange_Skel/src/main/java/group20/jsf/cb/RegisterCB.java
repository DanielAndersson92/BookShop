package group20.jsf.cb;
 
import group20.bookexchange.core.User;
import group20.jsf.bb.RegisterBB;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
 
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.RollbackException;
 

@Named("register")
@RequestScoped
public class RegisterCB implements Serializable {
 
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    
    @Inject
    private ExchangeBean bookExchange;
    
    @Inject
    private RegisterBB registerBB;
    
    @Inject
    private LoginBean loginBean;
    
    public String register(){
        
        User user = new User(registerBB.getFname(), registerBB.getLname(),
                registerBB.getCID(), registerBB.getEmail(), 
                registerBB.getPassword());
        try{
        bookExchange.getUserRegistry().add(user);
        }
        catch(RollbackException e){
            
        }
        return "login";
    }

     

     
}