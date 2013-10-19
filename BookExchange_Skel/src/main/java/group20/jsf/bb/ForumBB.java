/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.User;
import group20.bookexchange.forum.Post;
import group20.jsf.cb.LoginBean;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Date;
=======
>>>>>>> 0d6a335df70d565b1f30f67a0fff4a011a38dfb0
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.*;

/**
 *
 * @author Daniel
 */

@Named("forum")
@RequestScoped
public class ForumBB implements Serializable {
    
    @Inject
    private ExchangeBean bookExchange;
    @Inject
    private LoginBean logbean;
    
    private List<Post> posts;
    
    private String message;
    private User author;
    private Date date;
    
    @PostConstruct
    public void post() {
        posts = bookExchange.getPostList().getPosts();
    }

    public void sendPost(){
        Post p = new Post(message, new Date(), logbean.getUser());
        bookExchange.getPostList().add(p);
    }
    
    
    private void setPostar() {
        posts = bookExchange.getPostList().getPosts();
    }
    
    private List<Post> getPostar(){
        return bookExchange.getPostList().getPosts();
    }
    
    private void setMessage(String message){
        this.message = message;
    }
    
    private String getMessage(){
        return message;
    }
     private void setAuthor(User author){
        this.author = author;
    }
    
    private User getAuthor(){
        return author;
    }
     private void setDate(Date date){
        this.date = date;
    }
    
    private Date getDate(){
        return date;
    }
}
