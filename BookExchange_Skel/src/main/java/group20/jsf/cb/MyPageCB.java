/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.cb;

import group20.jsf.bb.MyPageBB;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
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
    
    @PostConstruct
    public void post() {
        mypageBB.setForSale();
        mypageBB.setWanted();
    }
    
}
