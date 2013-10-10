/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import java.util.Date;

/**
 *
 * @author Patrik
 */
public class BookExchangeFactory {
    
    
    private BookExchangeFactory(){
    
    }

    public static IBookExchange getBookExchange(String persistenceUnitName) {
        IBookExchange be = new BookExchange(persistenceUnitName);
        //if (initTestData) {
        //    initTestData(be);
        //}
        return be;
    }

    private static void initTestData(IBookExchange bookExchange) {
        User u = new User("Greta","Garbo","grega","greta.garbo@hollywood.com");
        bookExchange.getUserRegistry().add(u);
        bookExchange.getBookList().add(new Book("Signals, Systems ans Transforms", "PPE", 123, u, "TSS", Book.BookState.FORSALE, new Date(123L)));
        
        u = new User("Hans","Zimmer","hazi","hansz@hollywood.com");
        bookExchange.getUserRegistry().add(u);
        bookExchange.getBookList().add(new Book("Signals, Systems ans Transforms", "PPE", 123, u, "TSS", Book.BookState.WANTED, new Date(123123L)));
        
        u = new User("Beata","Rolfsdotter","bero","beata.butterfly@flix.com");
        bookExchange.getUserRegistry().add(u);
        bookExchange.getBookList().add(new Book("Vägen till C", "Jan Skansholm", 123, u, "MOP", Book.BookState.FORSALE, new Date(0L)));
        
        u = new User("Runar","Agustsson","runa","runar@gmail.com");
        bookExchange.getUserRegistry().add(u);
        bookExchange.getBookList().add(new Book("Vägen till C", "Jan Skansholm", 123, u, "MOP", Book.BookState.WANTED, new Date(123123123123123L)));
        
        u = new User("Tilde","Stenhage","tiste","tilde.92@lunar.se");
        bookExchange.getUserRegistry().add(u);
        bookExchange.getBookList().add(new Book("Signals, Systems ans Transforms", "PPE", 123, u, "TSS", Book.BookState.FORSALE, new Date(124L)));
        
    }
}
