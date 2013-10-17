/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.Book;
import group20.bookexchange.core.IBookList;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

/**
 *
 * @author alexandralazic
 */
public abstract class Conversational implements Serializable {
    @Inject
    private Conversation conversation;
    
    @Inject
    private ExchangeBean exchangeBean;
    
    private Long id;
    private String name;
    private String author;
    private String price;
    private String course;

    public void setSelected(String id){
        if (conversation.isTransient()) {
            conversation.begin();
        }
        Book b = exchangeBean.getBookList().find(Long.valueOf(id));
        this.id = b.getId();
        this.name = b.getTitle();
        this.author = b.getAuthor();
        this.price = String.valueOf(b.getPrice());
        this.course = b.getCourse();
    }
    
    @PreDestroy
    public void destroy() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }
    
    public String actOnSelected() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
        execute();
        return "";
    }
    
    protected abstract void execute();
    
    protected IBookList getBookList() {
        return exchangeBean.getBookList();
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return name;
    }
    public void setTitle(String name) {
        this.name = name;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }
            
    @Inject
    public void setShop(ExchangeBean eb){
        this.exchangeBean = eb;
    }
}
