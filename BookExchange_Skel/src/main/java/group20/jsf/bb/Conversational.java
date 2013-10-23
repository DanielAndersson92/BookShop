package group20.jsf.bb;

import group20.bookexchange.core.Book;
import group20.bookexchange.core.Book.BookState;
import group20.bookexchange.core.IBookList;
import group20.bookexchange.core.User;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

/**
 * 
 *
 * @author alexandralazic
 */
public abstract class Conversational implements Serializable {
    
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    
    @Inject
    private Conversation conversation;
    
    @Inject
    private ExchangeBean exchangeBean;
    
    private Long id;
    private String title;
    private String author;
    private String price;
    private User owner;
    private String course;
    private BookState bookState;
    private Date bookDate;
    private String descr;

    public void setSelected(Long id){
        if (conversation.isTransient()) {
            conversation.begin();
        }
        Book b = exchangeBean.getBookList().find(id);
        this.id = b.getId();
        this.title = b.getTitle();
        this.author = b.getAuthor();
        this.price = String.valueOf(b.getPrice());
        this.course = b.getCourse();
        this.owner = b.getOwner();
        this.bookState = b.getBookState();
        this.bookDate = b.getDate();
        this.descr = b.getDescr();
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
        return "mypage";
    }
    
    protected abstract void execute();
    
    
    /*
     * Getetrs and setters
     */
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
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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
    public User getUser(){
        return owner;
    }
    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public BookState getState(){
        return bookState;
    }
    public Date getDate(){
        return bookDate;
    }
    public String getDescr(){
        return descr;
    }
    public void setDescr(String descr){
        this.descr = descr;
    }   
}
