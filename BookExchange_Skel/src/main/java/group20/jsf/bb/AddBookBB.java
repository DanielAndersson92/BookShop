/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.Book;
import group20.bookexchange.core.Book.BookState;
import group20.bookexchange.core.User;
import group20.jsf.cb.LoginBean;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alexandralazic
 */
@Named("addBookBB")
@RequestScoped
public class AddBookBB implements Serializable{
    
    private String title;
    private String author;
    private String course;
    private int price;
    private User owner;
    private BookState bookState;
    
    @Inject
    private LoginBean logBean;
    
    @Inject
    private ExchangeBean exchangeBean;
    
    @Inject
    public void setShop(ExchangeBean s){
        this.exchangeBean = s;
    }
    
    public void save(){
        Book b = new Book(title, author, price, logBean.getUser(), course, bookState, new Date());
        exchangeBean.getBookList().add(b);
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
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public User getLoggedIn(){
        return owner;
    }   
    public void setLoggedIn(User owner){
        this.owner = owner;
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
}