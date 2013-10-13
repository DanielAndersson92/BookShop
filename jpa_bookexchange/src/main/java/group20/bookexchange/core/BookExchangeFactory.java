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

    public static IBookList getBookList() {
        return new BookList("BookExchange");
    }
    
    public static IBookExchange getBookExchange(boolean test) {
        IBookExchange be = new BookExchange("BookExchange");
        if(test){
            initTestData(be);
        }
        return be;
    }

    private static void initTestData(IBookExchange be) {
        IUserRegistry ur = be.getUserRegistry();
        IBookList bl = be.getBookList();
        
        User u1 = new User("Greta","Garbo","grega","greta@hollywood.com");
        ur.add(u1);
        User u2 = new User("Ingmar","Bergman","ingbe","ingmar@hollywood.com");
        ur.add(u2);
        
        Book b1 = new Book("Transformer, Signals and Systems", "PPE", 220, u1,
                "TSS", Book.BookState.FORSALE, new Date());
        Book b2 = new Book("Transformer, Signals and Systems", "PPE", 500, u2,
                "TSS", Book.BookState.WANTED, new Date());
        bl.add(b1);
        bl.add(b2);
        
        Book b3 = new Book("Vägen till C", "Jan Skansholm", 150, u1,
                "MOP", Book.BookState.WANTED, new Date());
        Book b4 = new Book("Vägen till C", "Jan Skansholm", 200, u2,
                "MOP", Book.BookState.FORSALE, new Date());
        bl.add(b3);
        bl.add(b4);
    }
}
