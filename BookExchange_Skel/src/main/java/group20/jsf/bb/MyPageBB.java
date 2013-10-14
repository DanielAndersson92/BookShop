/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.Book;
import group20.jsf.mb.ExchangeBean;
import group20.jsf.utils.ContainerNavigator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alexandralazic
 */
@Named("mypage")
@SessionScoped
public class MyPageBB implements Serializable {

    @Inject
    private ExchangeBean bookExchange;
    private Book.BookState bookState;
    private ContainerNavigator cn;
    private List<Book> wanted = new ArrayList<Book>();
    private List<Book> forSale = new ArrayList<Book>();
    private int numberOfBooks = 1;
    
    @PostConstruct
    public void post() {
        setForSale();
        setWanted();
    }
    
    public List<Book> getWanted(){
    //ska endast hämta inloggade användarens böcker        
        return wanted;
    }
    
    public void setWanted(){
        List<Book> books;
        books = bookExchange.getBookList().getByState(Book.BookState.WANTED);
        wanted = books.subList(0, numberOfBooks);
    }
    
    public List<Book> getForSale(){
    //ska endast hämta inloggade användarens böcker
        return forSale;
    }
    
    public void setForSale(){
        List<Book> books;
        books = bookExchange.getBookList().getByState(Book.BookState.FORSALE);
        forSale = books.subList(0, numberOfBooks);
    }
    
    public List<Book> getRange() {
        List<Book> bs = cn.getRange();
        return bs;
    }

    private void initialize() {
        cn = new ContainerNavigator(0, 10, bookExchange.getBookList());
        bookState = null;
    }
}