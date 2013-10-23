package group20.jsf.cb;

import group20.bookexchange.core.User;
import group20.bookexchange.pm.*;
import group20.jsf.bb.PmBB;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

/**
 * Creates conversations between users and sends pms.
 * @author Patrik
 */
@Named("pm")
@RequestScoped
public class PmCB implements Serializable{

    @Inject
    private ExchangeBean bookExchange;
    @Inject
    private LoginBean loginbean;
    @Inject
    private PmBB pmBB;
    
    public void send(){
        User user2 = pmBB.getReciever();
        PMPost p = new PMPost(pmBB.getMessage(), new Date(), loginbean.getUser());
        PMConversation c;
        try{
            c = bookExchange.getPMController().getConversationsList()
                    .getByUsers(user2, loginbean.getUser());
            c.addPost(p);
            bookExchange.getPMController().getConversationsList().update(c);
        }
        catch(NoResultException e){
            //A previous converstation does not extis, create new one.
            c = new PMConversation(loginbean.getUser(), user2, p);
            bookExchange.getPMController().getConversationsList().add(c);
        }
    }
    
    public PMConversation getConversations(){
        try{
            return bookExchange.getPMController().getConversationsList().getByUsers(loginbean.getUser(), pmBB.getReciever());
        }
        catch(NoResultException e){
            return null;
        }
    }
    
}
