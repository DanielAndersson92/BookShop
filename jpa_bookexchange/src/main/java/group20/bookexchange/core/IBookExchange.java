/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

<<<<<<< HEAD
import group20.bookexchange.pm.IPMController;
=======
import group20.bookexchange.forum.*;
>>>>>>> origin/databasFilter

/**
 *
 * @author Daniel
 */
public interface IBookExchange {
    
    public IUserRegistry getUserRegistry();
    
    public IBookList getBookList();
    
<<<<<<< HEAD
    public IPMController getPMController();
=======
    public IForumThread getPostList();
>>>>>>> origin/databasFilter
}
