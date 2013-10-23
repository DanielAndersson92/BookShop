package group20.jsf.bb;

import group20.bookexchange.core.Book;
import group20.bookexchange.core.Book.BookState;
import group20.jsf.cb.LoginBean;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Backing bean for addBook.xhtml
 *
 * @author alexandralazic
 */
@Named("addBookBB")
@RequestScoped
public class AddBookBB implements Serializable{
    
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    private String course;
    @Min(value=0)
    @Max(value=10000)
    private int price;
    private BookState bookState;
    private String descr;
    
    @Inject
    private LoginBean logBean;
    
    @Inject
    private ExchangeBean exchangeBean;
    
    /*
     * Saves a book in the database with the input values from addBook.xhtml
     */
    public void save(){
        Book b = new Book(title, author, price, logBean.getUser(), course, bookState, new Date(), descr);
        exchangeBean.getBookList().add(b);
    }
    
    /*
     * Getters and setters
     */
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
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    } 
    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public Book.BookState getBookState(){
        return bookState;
    }
    public void setBookState(Book.BookState state){
        bookState = state;
    }
    public String getDescr(){
        return descr;
    }
    public void setDescr(String descr){
        this.descr = descr;
    }
}