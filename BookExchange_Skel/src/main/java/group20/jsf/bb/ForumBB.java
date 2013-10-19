/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.forum.Post;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.*;

/**
 *
 * @author Daniel
 */

@Named("forum")
@SessionScoped
public class ForumBB implements Serializable {
    
    @Inject
    private ExchangeBean bookExchange;
    
    private List<Post> posts;
    
    @PostConstruct
    public void post() {
        setPosts();
    }

    private void setPosts() {
        posts = bookExchange.getPostList().getPosts();
    }
    
    private List<Post> getPosts(){
        return posts;
    }
}
