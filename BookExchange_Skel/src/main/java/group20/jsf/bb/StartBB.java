/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.Book;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author Patrik
 */
@Named("start")
@SessionScoped
public class StartBB implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("InfoLogging");

    @Inject
    private ExchangeBean bookExchange;
    
    private List<Book> wanted = new ArrayList<Book>();
    private List<Book> forSale = new ArrayList<Book>();
    private int numberOfBooks = 2;
    
    @PostConstruct
    public void post() {
        setForSale();
        setWanted();
    }
    
    public List<Book> getForSale(){
        return forSale;
    }
    
    public void setForSale(){
        forSale = bookExchange.getBookList().getRangeDate(numberOfBooks, Book.BookState.FORSALE);
        
    }
    
    public List<Book> getWanted(){
        return wanted;
    }
    
    public void setWanted(){
        wanted = bookExchange.getBookList().getRangeDate(numberOfBooks, Book.BookState.WANTED);
    }
}