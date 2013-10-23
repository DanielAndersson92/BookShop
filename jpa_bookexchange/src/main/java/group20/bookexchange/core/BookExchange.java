package group20.bookexchange.core;

import group20.bookexchange.guest.GuestThread;
import group20.bookexchange.guest.IGuestThread;
import group20.bookexchange.pm.*;

/**
 * BookExchange is the hub in our model.
 * @author Patrik
 */
public class BookExchange implements IBookExchange{

    private final BookList bookList;
    private final UserRegistry userRegistry;
    private final PMController pmController;
    private final GuestThread forumThread;
    
    public BookExchange(String puName){
        bookList = new BookList(puName);
        userRegistry = new UserRegistry(puName);
        pmController = new PMController(puName);
        forumThread = new GuestThread(puName);
    }
    
    @Override
    public IUserRegistry getUserRegistry() { return userRegistry; }
    @Override
    public IBookList getBookList() { return bookList; }
    @Override
    public IPMController getPMController() { return pmController; }
    @Override
    public IGuestThread getPostList() { return forumThread; }
}
