/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.forum.*;

/**
 *
 * @author Daniel
 */
public class BookExchange implements IBookExchange{

    private final BookList bookList;
    private final UserRegistry userRegistry;
    private final ForumThread forumThread;
    
    public BookExchange(String puName){
        bookList = new BookList(puName);
        userRegistry = new UserRegistry(puName);
        forumThread = new ForumThread(puName);
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
    public IForumThread getPostList() {
        return forumThread;
    }
}
