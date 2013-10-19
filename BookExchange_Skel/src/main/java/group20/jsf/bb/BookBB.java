/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.Book;
import java.io.Serializable;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alexandralazic
 */
@Named("bookBB")
@ConversationScoped
public class BookBB implements Serializable{
    
    @Inject
    private Conversation conversation;
    
    private Book book;
    
    @PreDestroy
    public void destroy() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }
    
    public String setBook(Book book){
        if (conversation.isTransient()) {
            conversation.begin();
        }
        this.book = book;
        return "bookpage";
    }
    
    public Book getBook(){
        return book;
    }

}
