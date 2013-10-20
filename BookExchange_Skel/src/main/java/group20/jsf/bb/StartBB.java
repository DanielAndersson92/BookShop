/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.Book;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author Patrik
 */
@Named("start")
@RequestScoped
public class StartBB implements Serializable {

    @Inject
    private ExchangeBean bookExchange;
    private int numberOfBooks = 10;
    
    public List<Book> getForSale(){
        return bookExchange.getBookList().getRangeDate(numberOfBooks, 
                Book.BookState.FORSALE);
    }
    
    public List<Book> getWanted(){
        return bookExchange.getBookList().getRangeDate(numberOfBooks, 
                Book.BookState.WANTED);
    }
}