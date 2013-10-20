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
    
    public List<Book> getWanted(){
        wanted = new ArrayList();
        try{
        List<Book> books = bookExchange.getBookList().getByUser(logBean.getUser());
        
            for(Book b:books){
                if (b.getBookState().equals(Book.BookState.WANTED)){
                    wanted.add(b);
                }
            }
        }
        catch(NullPointerException e){
            //If there is no user logged in then we just do nothing.
        }
        return wanted;
    }
    
    public void setWanted(){
        
    }
    
    public List<Book> getForSale(){
        forSale = new ArrayList();
        
        try{
        List<Book> books = bookExchange.getBookList().getByUser(logBean.getUser());
        
            for(Book b:books){
                if (b.getBookState().equals(Book.BookState.FORSALE)){
                    forSale.add(b);
                }
            }
        }
        catch(NullPointerException e){
            //If there is no user logged in then we just do nothing.
        }

        return forSale;
    }
    
    public void setForSale(){
        
    }
}