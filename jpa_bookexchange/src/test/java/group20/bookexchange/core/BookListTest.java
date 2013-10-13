/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.core.Book.BookState;
import static group20.bookexchange.core.UserRegistryTest.be;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Patrik
 */
public class BookListTest {
    @Before
    public void before() {
        be = BookExchangeFactory.getBookExchange(false);
    }
    
    //@Test
    public void testGetRange() {
        IUserRegistry ur = be.getUserRegistry();
        IBookList bl = be.getBookList();
        
        User u1 = new User("Greta","Garbo","grega","greta@hollywood.com");
        ur.add(u1);
        User u2 = new User("Ingmar","Bergman","ingbe","ingmar@hollywood.com");
        ur.add(u2);
        
        Book b1 = new Book("Transformer, Signals and Systems", "PPE", 220, u1,
                "TSS", BookState.FORSALE, new Date());
        Book b2 = new Book("Transformer, Signals and Systems", "PPE", 500, u2,
                "TSS", BookState.WANTED, new Date());
        bl.add(b1);
        bl.add(b2);
        
        Book b3 = new Book("Vägen till C", "Jan Skansholm", 150, u1,
                "MOP", BookState.WANTED, new Date());
        Book b4 = new Book("Vägen till C", "Jan Skansholm", 200, u2,
                "MOP", BookState.FORSALE, new Date());
        bl.add(b3);
        bl.add(b4);
        
        List<User> us = ur.getRange(0, 1000);
        assertTrue(us.size() == 2);
    }
    @Test
    public void testGetBy() {
        IUserRegistry ur = be.getUserRegistry();
        IBookList bl = be.getBookList();
        
        User u1 = new User("Greta","Garbo","grega","greta@hollywood.com");
        ur.add(u1);
        User u2 = new User("Ingmar","Bergman","ingbe","ingmar@hollywood.com");
        ur.add(u2);
        
        Book b1 = new Book("Transformer, Signals and Systems", "PPE", 220, u1,
                "TSS", BookState.FORSALE, new Date());
        Book b2 = new Book("Transformer, Signals and Systems", "PPE", 500, u2,
                "TSS", BookState.WANTED, new Date());
        bl.add(b1);
        bl.add(b2);
        
        Book b3 = new Book("Vägen till C", "Jan Skansholm", 150, u1,
                "MOP", BookState.WANTED, new Date());
        Book b4 = new Book("Vägen till C", "Jan Skansholm", 200, u2,
                "MOP", BookState.FORSALE, new Date());
        bl.add(b3);
        bl.add(b4);
        
        List<Book> books = bl.getByUser(u1);
        assertTrue(books.size() == 2);
        
        books = bl.getByState(BookState.FORSALE);
        assertTrue(books.size() == 2);
        
        books = bl.getByTitle("Vägen till C");
        assertTrue(books.size() == 2);
        
        books = bl.getByAuthor("Jan");
        System.out.println(books.toString());
        assertTrue(books.size() == 2);
        
        books = bl.getByCourse("TSS");
        assertTrue(books.size() == 2);
    }
}
