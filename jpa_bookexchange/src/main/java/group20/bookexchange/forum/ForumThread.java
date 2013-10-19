/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.forum;

import group20.bookexchange.db.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Daniel
 */
public class ForumThread extends AbstractDAO<Post, Long> implements IForumThread{
    
    public ForumThread(String puName){
        super(Post.class, puName);
    }
    
    @Override
    public List<Post> getPosts(){
        EntityManager em = getEMF().createEntityManager();
        List<Post> posts;
        TypedQuery<Post> q = em.createQuery
                ("SELECT p FROM Post p ", Post.class);
        posts = q.getResultList();
        em.close();
        return posts;
    }
}
