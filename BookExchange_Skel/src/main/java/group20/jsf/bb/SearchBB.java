/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.Book;
import group20.bookexchange.core.User;
import group20.jsf.mb.ExchangeBean;
import group20.jsf.utils.ContainerNavigator;
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
@Named("search")
@SessionScoped
public class SearchBB implements Serializable {

    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    
    @Inject
    private ExchangeBean bookExchange;
    private ContainerNavigator cn;

    @PostConstruct
    public void post() {

        cn = new ContainerNavigator(0, 3, bookExchange.getBookList());
    }
    
public List<Book> getRange() {
        List<Book> bs = cn.getRange();
        LOGGER.info(bs.toString());
        return bs;
    }

    public void next() { 
        cn.next();
    }

    public void prev() {
       cn.previous();
    }
    
    public void execute(){
        //cn = new ContainerNavigator(0,3, bookExchange.getBookList().getByTitle(null));
    }
}
