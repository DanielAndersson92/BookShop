package group20.jsf.bb;

import group20.bookexchange.core.User;
import java.io.Serializable;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * The backing bean for pm.xhtml.
 * @author Patrik
 */
@Named("pmBB")
@ConversationScoped
public class PmBB implements Serializable{

    private User reciever;
    private String message;
    
    @Inject
    private Conversation conversation;
    
    /*
     * Getters and setters
     */
    public void setReciever(User reciever){ 
        if (conversation.isTransient()) {
            conversation.begin();
        }
        this.reciever = reciever; }
    public User getReciever(){ return reciever; }
    
    public void setMessage(String message){ 
        this.message = message; 
    }
    public String getMessage(){ return message; }
    
   
    @PreDestroy
    public void destroy() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }
    
}
