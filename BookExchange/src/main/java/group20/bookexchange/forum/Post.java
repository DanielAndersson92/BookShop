/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.forum;

import group20.bookexchange.core.User;
import group20.bookexchange.utils.AbstractEntity;
import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Post extends AbstractEntity{
    public String message;
    public Date date;
    public final User author;
    
    public Post(String message, Date date ,User author){
        this.message = message;
        this.date = date;
        this.author = author;
    }
    public Post(Long id, String message, Date date, User author){
        super(id);
        this.message = message;
        this.date = date;
        this.author = author;
    }
    
}
