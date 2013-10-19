/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.forum;

import group20.bookexchange.core.User;
import group20.bookexchange.utils.AbstractEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel
 */
@Entity
public class Post extends AbstractEntity{
    private String message;
    @Temporal(TemporalType.DATE)
    private Date postDate;
    @ManyToOne
    public User author;

    public Post() {
    }
    
    public Post(String message, Date date ,User author){
        this.message = message;
        this.postDate = date;
        this.author = author;
    }
    public void setMessage(String message){ this.message = message; }
    public String getMessage() { return message; }
    
    public void setPostDate(Date postDate){ this.postDate = postDate; }
    public Date getPostDate() { return postDate; }
  
    public User getAuthor(){ return author; }
}
