/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.cb;


import group20.bookexchange.core.Book;
import group20.bookexchange.core.User;
import group20.jsf.bb.AddBookBB;
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
@Named("addbook")
@RequestScoped
public class AddBookCB implements Serializable{
    
    @Inject
    private ExchangeBean eb;
    
    @Inject
    private AddBookBB addbookBB;
    
    private String title;
    private String author;
    private String course;
    private int price;
    private User owner;
    private Book.BookState bookState;

    public String save(){
        Book b;
        b = new Book(title, author, price, owner, course, bookState, new Date(1L));
        eb.getBookList().add(b);
        return eb.toString();
    }

}
