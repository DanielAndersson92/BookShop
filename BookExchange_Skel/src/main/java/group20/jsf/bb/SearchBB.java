/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.Book;
import group20.jsf.utils.ContainerNavigator;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;


/**
 *
 * @author Patrik
 */
public class SearchBB implements Serializable{
    //Logger
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    
    private Book.BookState bookState;
    private ContainerNavigator containerNavigator;
    private List<String> selectedItems;
    private List<SelectItem> selectItems;
    
    public void setBookState(Book.BookState state){
        bookState = state;
    }
    public Book.BookState getBookState(){
        return bookState;
    }
    public void setContainerNavigator(ContainerNavigator containerNavigator){
        this.containerNavigator = containerNavigator;
    }
    public ContainerNavigator getContainerNavigator(){
        return containerNavigator;
    }
    public void setSelectedItems(List<String> selectedItems){
        this.selectedItems = selectedItems;
    }
    public List<String> getSelectedItems(){
        return selectedItems;
    }
    public void setSelectItems(List<SelectItem> selectItems){
        this.selectItems = selectItems;
    }
    public List<SelectItem> getSelectItems(){
        return selectItems;
    }
}