/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

/**
 *
 * @author Patrik
 */
public class BookExchangeFactory {
    
    
    private BookExchangeFactory(){
    
    }

    public static IBookExchange getBookExchange(boolean initTestData) {
        IBookExchange be = new BookExchange();
        if (initTestData) {
            initTestData(be);
        }
        return be;
    }

    private static void initTestData(IBookExchange bookExchange) {
        User u = new User(1L, "Greta","Garbo","grega","greta.garbo@hollywood.com");
        bookExchange.getUserRegistry().add(u);
        bookExchange.getBookList().add(new Book("Signals, Systems ans Transforms", "PPE", 123, u, "TSS", Book.BookState.FORSALE));
        
        u = new User(2L, "Hans","Zimmer","hazi","hansz@hollywood.com");
        bookExchange.getUserRegistry().add(u);
        bookExchange.getBookList().add(new Book("Signals, Systems ans Transforms", "PPE", 123, u, "TSS", Book.BookState.WANTED));
        
        u = new User(3L, "Beata","Rolfsdotter","bero","beata.butterfly@flix.com");
        bookExchange.getUserRegistry().add(u);
        bookExchange.getBookList().add(new Book("Vägen till C", "Jan Skansholm", 123, u, "MOP", Book.BookState.FORSALE));
        
        u = new User(4L, "Runar","Agustsson","runa","runar@gmail.com");
        bookExchange.getUserRegistry().add(u);
        bookExchange.getBookList().add(new Book("Vägen till C", "Jan Skansholm", 123, u, "MOP", Book.BookState.WANTED));
        
        u = new User(5L, "Tilde","Stenhage","tiste","tilde.92@lunar.se");
        bookExchange.getUserRegistry().add(u);
        bookExchange.getBookList().add(new Book("Signals, Systems ans Transforms", "PPE", 123, u, "TSS", Book.BookState.FORSALE));
        
    }
}
