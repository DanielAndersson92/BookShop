/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.forum;

import group20.bookexchange.db.AbstractDAO;

/**
 *
 * @author Daniel
 */
public class ForumThread extends AbstractDAO<Post, Long> implements IForumThread{
    
    public ForumThread(String puName){
        super(Post.class, puName);
    }
    
}
