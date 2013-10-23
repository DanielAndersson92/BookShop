package group20.jsf.cb;
 
import group20.bookexchange.core.User;
import group20.jsf.bb.RegisterBB;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
 
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.RollbackException;
 

/**
 * Creates a user object and stores it in the database.
 * @author Patrik
 */
@Named("register")
@RequestScoped
public class RegisterCB implements Serializable {
   
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