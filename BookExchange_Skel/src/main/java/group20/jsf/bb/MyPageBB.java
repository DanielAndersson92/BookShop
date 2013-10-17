/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.Book;
import group20.jsf.cb.LoginBean;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import javax.enterprise.context.SessionScoped;
=======
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
>>>>>>> origin/databasFilter
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alexandralazic
 */
@Named("mypageBB")
<<<<<<< HEAD
@SessionScoped
=======
@RequestScoped
>>>>>>> origin/databasFilter
public class MyPageBB implements Serializable {

    @Inject
    private ExchangeBean bookExchange;
<<<<<<< HEAD
    private List<Book> wanted = new ArrayList<Book>();
    private List<Book> forSale = new ArrayList<Book>();
    
=======
    private List<Book> wanted;
    private List<Book> forSale;
    @Inject
    private LoginBean logBean;
        
    @PostConstruct
    public void post() {
        setWanted();
        setForSale();
    }
>>>>>>> origin/databasFilter
    
    public List<Book> getWanted(){
        return wanted;
    }
    
    public void setWanted(){
        List<Book> books;
        books = bookExchange.getBookList().getByUser(logBean.getUser());
        wanted = new ArrayList();
        for(Book b:books){
            if (b.getBookState().equals(Book.BookState.WANTED)){
                wanted.add(b);
            }
        }
    }
    
    public List<Book> getForSale(){
        return forSale;
    }
    
    public void setForSale(){
        List<Book> books;
        books = bookExchange.getBookList().getByUser(logBean.getUser());
        forSale = new ArrayList();
        for(Book b:books){
            if (b.getBookState().equals(Book.BookState.FORSALE)){
                forSale.add(b);
            }
        }
    }
<<<<<<< HEAD
=======
    
    public List<Book> getRange() {
        List<Book> bs = bookExchange.getBookList().getByUser(logBean.getUser());
        return bs;
    }
>>>>>>> origin/databasFilter
}