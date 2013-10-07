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

    private BookList bookList;
    private UserRegistry userRegistry;
    
    public BookExchange(){
    
    }
    
    @Override
    public IUserRegistry getUserRegistry() {
        return userRegistry;
    }

    @Override
    public IBookList getBookList() {
        return bookList;
    }
}
