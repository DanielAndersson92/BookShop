/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.pm;

import group20.bookexchange.core.User;
import group20.bookexchange.forum.Post;
import group20.bookexchange.utils.AbstractEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 *
 * @author Patrik
 */
@Entity
public class Conversation extends AbstractEntity{
    @OneToMany(targetEntity=User.class)
    private List<User> users;
    @OneToMany(cascade = {CascadeType.ALL}, targetEntity=Post.class)
    //@OrderBy("postDate DESC")
    private List<Post> posts;
    
    public Conversation(){
    }
    public Conversation(User u1, User u2, Post post){
        users = new ArrayList();
        users.add(u1);
        users.add(u2);
        posts = new ArrayList();
        posts.add(post);
    }
}
