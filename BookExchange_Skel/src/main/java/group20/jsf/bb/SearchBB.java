/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.Book;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;


/**
 *
 * @author Patrik
 */
@Named("searchBB")
@SessionScoped
public class SearchBB implements Serializable{

    private Book.BookState bookState;
    private List<String> selectedItems;
    private List<SelectItem> selectItems;
    private String input;
    private int rangeStart;
    private int range;
    
    public void setBookState(Book.BookState state){ bookState = state; }
    public Book.BookState getBookState(){ return bookState; }
    
    public void setSelectedItems(List<String> selectedItems){ this.selectedItems = selectedItems; }
    public List<String> getSelectedItems(){ return selectedItems; }
    
    public void setSelectItems(List<SelectItem> selectItems){ this.selectItems = selectItems; }
    public List<SelectItem> getSelectItems(){ return selectItems; }
    
    public void setInput(String input){ this.input = input; }
    public String getInput() { return input; }
    
    public void setRange(int range){ this.range = range; }
    public int getRange() { return range; }
    
    public void setRangeStart( int rangeStart){ this.rangeStart = rangeStart; }
    public int getRangeStart() { return rangeStart; }
}