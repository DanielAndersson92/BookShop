/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

/**
 *
 * @author Daniel
 */
public class BookExchange implements IBookExchange{

    private BookList wanted;
    private BookList sellable;
    private UserRegistry userRegistry;
    
    public BookExchange(){
    
    }
    
    @Override
    public IUserRegistry getUserRegistry() {
        return userRegistry;
    }

    @Override
    public IBookList getWanted() {
        return wanted;
    }

    @Override
    public IBookList getSellable() {
        return sellable;
    }
}
