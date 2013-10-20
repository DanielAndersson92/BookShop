/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.utils.AbstractEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel
 */
@Entity
public class Book extends AbstractEntity{
    
    public enum BookState{
        WANTED,
        FORSALE,
        BOOKED,
        SOLD,
    }
    
    private String title;
    private String author;
    private int price;
    @ManyToOne
    private User owner;
    private String course;
    @Enumerated(EnumType.STRING)
    private BookState bookState;
    @Temporal(TemporalType.DATE)
    private Date bookDate;
    private String descr;
    
    public Book() {
    }
    
    public Book(String title, String author, int price, User owner, 
            String course, BookState bookState, Date bookDate, String descr){
        this.title = title;
        this.author = author;
        this.price = price;
        this.owner = owner;
        this.course = course;
        this.bookState = bookState;
        this.bookDate = bookDate;
        this.descr = descr;
    }
    
    public Book(Long id, String title, String author, int price, User owner, 
            String course, BookState bookState, Date bookDate, String descr){
        super(id);
        this.title = title;
        this.author = author;
        this.price = price;
        this.owner = owner;
        this.course = course;
        this.bookState = bookState;
        this.bookDate = bookDate;
        this.descr = descr;
    }
    
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public User getOwner(){
        return owner;
    }
    public String getCourse(){
        return course;
    }
    public BookState getBookState(){
        return bookState;
    }
    public void setBookState(BookState state){
        bookState = state;
    }
    public void setDate(Date bookDate){
        this.bookDate = bookDate;
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
