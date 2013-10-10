/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.Book;
import group20.bookexchange.core.BookList;
import group20.bookexchange.core.IBookList;
import group20.jsf.mb.ExchangeBean;
import group20.jsf.utils.ContainerNavigator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
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
    
    private Book.BookState bookState;
    private ContainerNavigator cn;
    private List<String> selectedItems;
    private List<SelectItem> selectItems;
    
    @PostConstruct
    public void post() {
        initialize();
    }
    
public List<Book> getRange() {
        List<Book> bs = cn.getRange();
        LOGGER.info(bs.toString());
        return bs;
    }

    
    public void initialize(){
        
        cn = new ContainerNavigator(0, 5, bookExchange.getBookList());
        bookState = null;
        
        selectedItems = new ArrayList<String>();
        selectedItems.add("all");
        
        selectItems = new ArrayList<SelectItem>();
        selectItems.add(new SelectItem("all", "All"));
        selectItems.add(new SelectItem("title", "Title"));
        selectItems.add(new SelectItem("author", "Author"));
        selectItems.add(new SelectItem("course", "Course"));
        
    }
   
    public Book.BookState getBookState(){
        return bookState;
    }
    
    public List<SelectItem> getSelectItems(){
        return selectItems;
    }
    public List<String> getSelectedItems(){
        return selectedItems;
    }
    public void setSelectedItems(List<String> selectedItems){
        this.selectedItems = selectedItems;
    }
    
    
    public void reset(){
        initialize();
    }
}