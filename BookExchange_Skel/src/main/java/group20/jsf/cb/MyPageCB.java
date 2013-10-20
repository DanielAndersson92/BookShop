/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.cb;

import group20.bookexchange.pm.PMConversation;
import group20.bookexchange.pm.PMPost;
import group20.jsf.bb.MyPageBB;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

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
    
    @Inject
    private LoginBean logBean;
    
    @PostConstruct
    public void post() {

    }
    public List<PMConversation> getConversations(){
        try{
            return bookExchange.getPMController().getConversationsList().getByUser(logBean.getUser());
        }
        catch(NoResultException e){
            return null;
        }
    }
    public PMPost getPost(PMConversation c){
        return c.getPosts().get(c.getPosts().size() - 1);
    }
    
}