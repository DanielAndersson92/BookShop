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
    private ContainerNavigator conNav;
    private List<Book> wanted = new ArrayList<Book>();
    private List<Book> forSale = new ArrayList<Book>();
    
    
    public List<Book> getWanted(){
        return wanted;
    }
    
    public void setWanted(){
        //inte bara sätta efter state, även efter user
        List<Book> books;
        books = bookExchange.getBookList().getByState(Book.BookState.WANTED);
        wanted = books.subList(0, 1);
    }
    
    public List<Book> getForSale(){
    //ska endast hämta inloggade användarens böcker
        return forSale;
    }
    
    public void setForSale(){
        //inte bara sätta efter state, även efter user
        List<Book> books;
        books = bookExchange.getBookList().getByState(Book.BookState.FORSALE);
        forSale = books.subList(0, 1);
    }
    
    public List<Book> getRange() {
        List<Book> bs = conNav.getRange();
        return bs;
    }
    
}