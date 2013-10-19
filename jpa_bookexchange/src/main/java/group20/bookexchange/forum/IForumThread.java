/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.forum;

import group20.bookexchange.db.IDAO;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface IForumThread extends IDAO<Post,Long>{
    
    public List<Post> getPosts();
}
