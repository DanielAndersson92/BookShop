package group20.bookexchange.core;

import group20.bookexchange.guest.IGuestThread;
import group20.bookexchange.pm.IPMController;

/**
 * BookExchange is the hub in our model.
 * @author Daniel
 */
public interface IBookExchange {
    
    public IUserRegistry getUserRegistry();
    
    public IBookList getBookList();
    
    public IPMController getPMController();
    public IGuestThread getPostList();
}
