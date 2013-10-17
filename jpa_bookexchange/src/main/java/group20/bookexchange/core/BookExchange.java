/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

<<<<<<< HEAD
import group20.bookexchange.pm.*;
=======
import group20.bookexchange.forum.*;
>>>>>>> origin/databasFilter

/**
 *
 * @author Daniel
 */
public class BookExchange implements IBookExchange{

    private final BookList bookList;
    private final UserRegistry userRegistry;
<<<<<<< HEAD
    private final PMController pmController;
=======
    private final ForumThread forumThread;
>>>>>>> origin/databasFilter
    
    public BookExchange(String puName){
        bookList = new BookList(puName);
        userRegistry = new UserRegistry(puName);
<<<<<<< HEAD
        pmController = new PMController(puName);
=======
        forumThread = new ForumThread(puName);
>>>>>>> origin/databasFilter
    }
    
    @Override
    public IUserRegistry getUserRegistry() {
        return userRegistry;
    }

    @Override
    public IBookList getBookList() {
        return bookList;
    }
<<<<<<< HEAD
    
    @Override
    public IPMController getPMController() {
        return pmController;
=======

    @Override
    public IForumThread getPostList() {
        return forumThread;
>>>>>>> origin/databasFilter
    }
}
