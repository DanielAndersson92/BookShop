/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.Book;
import group20.jsf.mb.ExchangeBean;
import group20.jsf.utils.ContainerNavigator;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alexandralazic
 */
@Named("mypage")
@SessionScoped
public class MyPageBB implements Serializable {

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
        return bs;
    }

    private void initialize() {
        cn = new ContainerNavigator(0, 10, bookExchange.getBookList());
        bookState = null;
    }

}
