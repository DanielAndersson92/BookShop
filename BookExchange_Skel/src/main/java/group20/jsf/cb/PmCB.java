/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.cb;

import group20.bookexchange.core.User;
import group20.bookexchange.forum.*;
import group20.bookexchange.pm.*;
import group20.jsf.bb.PmBB;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Patrik
 */
@Named("pm")
@SessionScoped
public class PmCB implements Serializable{
    
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    
    @Inject
    private ExchangeBean bookExchange;
    @Inject
    private LoginBean loginbean;
    @Inject
    private PmBB pmBB;
    
    public void send(){
        User user2 = bookExchange.getUserRegistry().getByCID(pmBB.getReciever());
        Post p = new Post(pmBB.getMessage(), new Date(), loginbean.getUser());
        PMConversation c;
        try{
            c = bookExchange.getPMController().getConversationsList()
                    .getByUsers(user2, loginbean.getUser());
            c.addPost(p);
            bookExchange.getPMController().getConversationsList().update(c);
        }
        catch(Exception e){
            c = new PMConversation(loginbean.getUser(), user2, p);
            bookExchange.getPMController().getConversationsList().add(c);
        }
    }
    
    public List<PMConversation> getConversations(){
        LOGGER.info(bookExchange.getPMController().getConversationsList().getByUser(loginbean.getUser()).toString());
        return bookExchange.getPMController().getConversationsList().getByUser(loginbean.getUser());
    }
    
}
