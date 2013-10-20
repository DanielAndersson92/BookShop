/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.forum;

import group20.bookexchange.utils.AbstractEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel
 */
@Entity
public class Post extends AbstractEntity{
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
    private String author;

    public Post() {
    }
    
    public Post(String message, Date date , String author){
        this.message = message;
        this.postDate = date;
        this.author = author;
    }
    public void setMessage(String message){ this.message = message; }
    public String getMessage() { return message; }
    
    public void setPostDate(Date postDate){ this.postDate = postDate; }
    public Date getPostDate() { return postDate; }
  
    public String getAuthor(){ return author; }
}
