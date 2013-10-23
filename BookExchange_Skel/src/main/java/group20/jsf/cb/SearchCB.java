package group20.jsf.cb;

import group20.bookexchange.core.Book;
import group20.bookexchange.core.IBookList;
import group20.jsf.bb.SearchBB;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Provides logic for searching after Books.
 * @author Patrik
 */
@Named("search")
@SessionScoped
public class SearchCB implements Serializable{
    
    private static final String DEFAULT_SEARCH = "Search your feelings..";
    
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
        
        searchBB.setRangeStart(0);
        searchBB.setRange(3);
        
        searchBB.setInput(DEFAULT_SEARCH);
        
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
    public List<Book> getList() {
        
        if(searchBB.getInput()!= null && !searchBB.getInput().equals(DEFAULT_SEARCH))
        {
            String sought = searchBB.getInput();
            
            List<String> soughts = new ArrayList();
            soughts.addAll(Arrays.asList(sought.split("\\W")));
            soughts.add(sought);
            
            IBookList bookList = bookExchange.getBookList();
            Set<Book> fbs = new HashSet();
            for(String s : soughts){
                if(searchBB.getSelectedItems().contains("title") || 
                        searchBB.getSelectedItems().contains("all")){
                    fbs.addAll(bookList.getByTitle(s));
                }
                if(searchBB.getSelectedItems().contains("author") || 
                        searchBB.getSelectedItems().contains("all")){
                    fbs.addAll(bookList.getByAuthor(s));
                }
                if(searchBB.getSelectedItems().contains("course") || 
                        searchBB.getSelectedItems().contains("all")){
                    fbs.addAll(bookList.getByCourse(s));
                }
            }
            if(searchBB.getBookState() != null){
                Set<Book> nbs = new HashSet();
                for(Book b : fbs){
                    if(b.getBookState().equals(searchBB.getBookState()))
                        nbs.add(b);
                }
                fbs = nbs;
            }
            List<Book> bs = new ArrayList(fbs);
            int count = bs.size();
            int first = searchBB.getRangeStart();
            int nItems = searchBB.getRange();
            first = first > count ? 0 : first;
            nItems = (first + nItems) > count ? (count - first) : nItems;
            searchBB.setRangeStart(first);
            return bs.subList(searchBB.getRangeStart(), searchBB.getRangeStart()+nItems);
        }
        if(searchBB.getBookState() != null){
            return bookExchange.getBookList().getByState(searchBB.getBookState());
        }
        return bookExchange.getBookList().getRange(searchBB.getRangeStart(),
                searchBB.getRange());
    }
    /**
     * Gets the next N Books if there are any, where N is predefined in code.
     */
    public void next() { 
        int count = bookExchange.getBookList().getCount();
        int first = searchBB.getRangeStart();
        int nItems = searchBB.getRange();
        searchBB.setRangeStart((first + nItems < count) ? first + nItems : first);
    }
    /**
     * Gets the previous N Btems if there are any, where N is predefined in code.
     */
    public void prev() {
        int first = searchBB.getRangeStart();
        int nItems = searchBB.getRange();
         searchBB.setRangeStart((first - nItems > 0) ? first - nItems : 0);

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
    public void execute(){
        if(searchBB.getInput()==null) initialize();
        else{
            searchBB.setRangeStart(0);
        }
    }
}
