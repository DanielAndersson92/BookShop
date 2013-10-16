/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.pm.*;

/**
 *
 * @author Daniel
 */
public class BookExchange implements IBookExchange{

    private final BookList bookList;
    private final UserRegistry userRegistry;
    private final PMController pmController;
    
    public BookExchange(String puName){
        bookList = new BookList(puName);
        userRegistry = new UserRegistry(puName);
        pmController = new PMController(puName);
    }
    
    @Override
    public IUserRegistry getUserRegistry() {
        return userRegistry;
    }

    @Override
    public IBookList getBookList() {
        return bookList;
    }
    
    @Override
    public IPMController getPMController() {
        return pmController;
    }
}
