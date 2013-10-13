/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.mb;

import group20.bookexchange.core.BookExchangeFactory;
import group20.bookexchange.core.IBookExchange;
import group20.bookexchange.core.IBookList;
import group20.bookexchange.core.IUserRegistry;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author Daniel
 */


@Singleton
public class ExchangeBean implements Serializable{

    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    private final IBookExchange bookExchange;
    
    @Inject
    public ExchangeBean() {
        LOGGER.info("Exchangebean is under the way of being built.");
        bookExchange = BookExchangeFactory.getBookExchange(true);
    }
    
    public IBookList getBookList(){
        return bookExchange.getBookList();
    }
    
    public IUserRegistry getUserRegistry(){
        return bookExchange.getUserRegistry();
    }
    
}