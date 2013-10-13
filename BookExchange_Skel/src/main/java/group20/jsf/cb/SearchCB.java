package group20.jsf.cb;

import group20.bookexchange.core.Book;
import group20.bookexchange.core.BookList;
import group20.bookexchange.core.IBookList;
import group20.jsf.bb.SearchBB;
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
@Named("search")
@SessionScoped
public class SearchCB implements Serializable{
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    
    
    @Inject
    private ExchangeBean bookExchange;
    @Inject 
    private SearchBB searchBB;

    /**
     * What is to be done after the bean is created.
     */
    @PostConstruct
    public void post() {
        initialize();
    }
    /**
     * Initializes the Search page. 
     */
    public void initialize(){
        /*
         * Initializes the ContainerNavigator with the entire collection of Books
         * and points to the first and gives N items with getRange.
         */
        searchBB.setContainerNavigator(
                new ContainerNavigator(0, 3, bookExchange.getBookList()));
        
        // The radiobuttons will not have any alternative preselected.
        searchBB.setBookState(null);
        
        // Sets the preselected options for the checkboxes to "All".
        List<String> selectedItems = new ArrayList<String>();
        selectedItems.add("all");
        searchBB.setSelectedItems(selectedItems);
        
        // These are the checkboxes.
        List<SelectItem> selectItems = new ArrayList<SelectItem>();
        selectItems.add(new SelectItem("all", "All"));
        selectItems.add(new SelectItem("title", "Title"));
        selectItems.add(new SelectItem("author", "Author"));
        selectItems.add(new SelectItem("course", "Course"));
        searchBB.setSelectItems(selectItems);
        
    }
    /**
     * Returns N Books, where N is predefined in code. 
     * @return N Books.
     */
    public List<Book> getRange() {
        List<Book> bs = searchBB.getContainerNavigator().getRange();
        LOGGER.info(bs.toString());
        return bs;
    }
    /**
     * Gets the next N Books if there are any, where N is predefined in code.
     */
    public void next() { 
        searchBB.getContainerNavigator().next();
    }
    /**
     * Gets the previous N Btems if there are any, where N is predefined in code.
     */
    public void prev() {
       searchBB.getContainerNavigator().previous();
    }
    /**
     * Resets the Search page.
     */
    public void reset(){
        initialize();
    }
    /**
     * Sets the ContainerNavigator to contain only the Books that applies to
     * any of the words given in sought or, if no Books was found, reset the
     * Search page.
     * @param sought A string containing what is sought.
     */
    public void execute(String sought){
        
        if(searchBB.getBookState() != null) 
            LOGGER.info(searchBB.getBookState().toString());
        
        if(!sought.equals(""))
        {
            List<String> soughts = new ArrayList();
            soughts.addAll(Arrays.asList(sought.split("\\W")));
            soughts.add(sought);
            
            IBookList bookList = bookExchange.getBookList();
            IBookList newBookList = new BookList();
            List<Book> bs = new ArrayList();
            for(String s : soughts){
                LOGGER.info(s);
                if(searchBB.getSelectedItems().contains("title") || 
                        searchBB.getSelectedItems().contains("all")){
                    bs.addAll(bookList.getByTitle(s));
                }
                if(searchBB.getSelectedItems().contains("author") || 
                        searchBB.getSelectedItems().contains("all")){
                    bs.addAll(bookList.getByAuthor(s));
                }
                if(searchBB.getSelectedItems().contains("course") || 
                        searchBB.getSelectedItems().contains("all")){
                    bs.addAll(bookList.getByCourse(s));
                }
            }
            for(Book b : bs){
                if(searchBB.getBookState() != null){
                    if(b.getBookState() == searchBB.getBookState()) newBookList.add(b);
                }
                else newBookList.add(b);
            }
            searchBB.setContainerNavigator(new ContainerNavigator(0, 3, newBookList));
        }
        else{
            initialize();
        }
    }
    /*
     * Setters and getters for SearchBB.
     */
    public void setBookState(Book.BookState state){
        searchBB.setBookState(state);
    }
    public Book.BookState getBookState(){
        return searchBB.getBookState();
    }
    
    public List<SelectItem> getSelectItems(){
        return searchBB.getSelectItems();
    }
    public void setSelectedItems(List<String> selectedItems){
        searchBB.setSelectedItems(selectedItems);
    }
    public List<String> getSelectedItems(){
        return searchBB.getSelectedItems();
    }
}
