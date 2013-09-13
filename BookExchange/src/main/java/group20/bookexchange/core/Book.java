/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.utils.AbstractEntity;

/**
 *
 * @author Daniel
 */
public class Book extends AbstractEntity{
    
    private String name;
    private String author;
    private int price;
    private User owner;
    private String course;
    
    public Book(String name, String author, int price, User owner, 
            String course){
        this.name = name;
        this.author = author;
        this.price = price;
        this.owner = owner;
        this.course = course;
    }
    public Book(Long id, String name, String author, int price, User owner){
        super(id);
        this.name = name;
        this.author = author;
        this.price = price;
        this.owner = owner;
    }
    
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public void setName(String name){
        this.name = name;
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
}
