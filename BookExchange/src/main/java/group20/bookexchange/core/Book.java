/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.utils.AbstractEntity;
import java.util.Date;

/**
 *
 * @author Daniel
 */
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
    private User owner;
    private String course;
    private BookState bookState;
    private Date bookDate;
    
    public Book(String title, String author, int price, User owner, 
            String course, BookState bookState, Date bookDate){
        this.title = title;
        this.author = author;
        this.price = price;
        this.owner = owner;
        this.course = course;
        this.bookState = bookState;
        this.bookDate = bookDate;
    }
    public Book(Long id, String title, String author, int price, User owner,
            BookState bookState, Date bookDate){
        super(id);
        this.title = title;
        this.author = author;
        this.price = price;
        this.owner = owner;
        this.bookState = bookState;
        this.bookDate = bookDate;
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
}
