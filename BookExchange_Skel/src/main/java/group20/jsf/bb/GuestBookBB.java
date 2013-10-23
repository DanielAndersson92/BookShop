package group20.jsf.bb;

import group20.bookexchange.forum.Post;
import group20.jsf.cb.LoginBean;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.*;

/*
 * Backing bean for guestBook.xhtml
 *
 * @author Daniel
 */

@Named("guestBook")
@RequestScoped
public class GuestBookBB implements Serializable {
    
    @Inject
    private ExchangeBean bookExchange;
    @Inject
    private LoginBean logbean;
    
    private List<Post> posts;
    
    private String message;
    private String author;
    private Date date;
    
    @PostConstruct
    public void post() {
        posts = bookExchange.getPostList().getPosts();
    }

    public void sendPost(){
        
        if(logbean.isLoggedIn()){
            author = logbean.getUser().getFname() 
                + " " + logbean.getUser().getLname();
        }
        bookExchange.getPostList().add(new Post(message, new Date(), author));
    }
    
    /*
     * Getters and setters
     */
    
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
     private void setAuthor(String author){
        this.author = author;
    }
    
    private String getAuthor(){
        return author;
    }
     private void setDate(Date date){
        this.date = date;
    }
    
    private Date getDate(){
        return date;
    }
}
