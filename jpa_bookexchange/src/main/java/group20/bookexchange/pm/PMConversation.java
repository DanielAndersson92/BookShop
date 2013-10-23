/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.pm;

import group20.bookexchange.core.User;
import group20.bookexchange.utils.AbstractEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 * PMConversation represents a conversation between two users.
 * @author Patrik
 */
@Entity
public class PMConversation extends AbstractEntity{
    @OneToMany
    private List<User> users;
    @OneToMany(cascade = {CascadeType.ALL}, targetEntity=PMPost.class)
    @OrderBy("postDate DESC")
    private List<PMPost> posts;
    
    public PMConversation(){
    }
    public PMConversation(User u1, User u2, PMPost post){
        users = new ArrayList();
        users.add(u1);
        users.add(u2);
        posts = new ArrayList();
        posts.add(post);
    }
    public PMConversation(Long id, List<User> users, List<PMPost> posts){
        super(id);
        this.users = users;
        this.posts = posts;
    }
    
    public List<User> getUsers(){ return users; }
    public List<PMPost> getPosts(){ return posts; }
    public void addPost(PMPost post){
        posts.add(post);
    }
}
