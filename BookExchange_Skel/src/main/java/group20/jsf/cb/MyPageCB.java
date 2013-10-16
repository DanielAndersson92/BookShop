/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.cb;

import group20.bookexchange.core.Book;
import group20.jsf.bb.MyPageBB;
import group20.jsf.mb.ExchangeBean;
import group20.jsf.utils.ContainerNavigator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alexandralazic
 */
@Named("mypage")
@RequestScoped
public class MyPageCB implements Serializable{
    
    @Inject
    private ExchangeBean bookExchange;
    
    @Inject 
    private MyPageBB mypageBB;
    
    private ContainerNavigator conNav;
    private List<Book> wanted = new ArrayList<Book>();
    private List<Book> forSale = new ArrayList<Book>();
    
    @PostConstruct
    public void post() {
        mypageBB.setForSale();
        mypageBB.setWanted();
    }
    
}
