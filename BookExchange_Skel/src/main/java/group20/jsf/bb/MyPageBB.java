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
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alexandralazic
 */
@Named("mypageBB")
@RequestScoped
public class MyPageBB implements Serializable {

    @Inject
    private ExchangeBean bookExchange;
    private List<Book> wanted;
    private List<Book> forSale;
    @Inject
    private LoginBean logBean;
        
    @PostConstruct
    public void post() {
        setWanted();
        setForSale();
    }
    
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
    
    public List<Book> getRange() {
        List<Book> bs = bookExchange.getBookList().getByUser(logBean.getUser());
        return bs;
    }
    
    public String navigate(String target) {
        return target;
    }
}