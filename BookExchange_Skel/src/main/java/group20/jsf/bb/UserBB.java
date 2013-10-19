/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.User;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Patrik
 */
@Named("userBB")
@ConversationScoped
public class UserBB implements Serializable{
    
    private static final Logger LOGGER = Logger.getLogger("InfoLogging"); 
    
    @NotNull
    private User user;
    @Inject
    private Conversation conversation;
    
    @PreDestroy
    public void destroy() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }
    
    public String setUser(User user){ 
        if (conversation.isTransient()) {
            conversation.begin();
        }
        LOGGER.info("setUser = "+user.getCID());
        this.user = user; 
        return "user";
    }
    public User getUser() { 
        LOGGER.info("getUser = "+user.getCID());
        return user; 
    }
}
