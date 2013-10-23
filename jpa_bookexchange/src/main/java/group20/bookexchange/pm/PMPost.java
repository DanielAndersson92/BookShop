/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.pm;

import group20.bookexchange.core.User;
import group20.bookexchange.utils.AbstractEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PMPost represents a post in a PMConversation.
 * @author Daniel
 */
@Entity
public class PMPost extends AbstractEntity{
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date postDate;
    @ManyToOne
    private User author;
    private Boolean unread;

    public PMPost() {
    }
    
    public PMPost(String message, Date date ,User author){
        this.message = message;
        this.postDate = date;
        this.author = author;
        unread = false;
    }
    public void setMessage(String message){ this.message = message; }
    public String getMessage() { return message; }
    
    public void setPostDate(Date postDate){ this.postDate = postDate; }
    public Date getPostDate() { return postDate; }
  
    public User getAuthor(){ return author; }
    
    public void setUnread(Boolean unread){ this.unread = unread; }
    public Boolean getUnread() { return unread; }
    
}
