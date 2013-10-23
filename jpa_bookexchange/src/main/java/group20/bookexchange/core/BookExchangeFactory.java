package group20.bookexchange.core;

import group20.bookexchange.forum.Post;
import group20.bookexchange.forum.ForumThread;
import group20.bookexchange.forum.IForumThread;
import java.util.Date;

/**
 * Produces the BookExchange. Use the 'test' variable to get preprogrammed 
 * users and books.
 * @author Patrik
 */
public class BookExchangeFactory {
    
    private BookExchangeFactory(){ 
    }

    public static IBookList getBookList() {
        return new BookList("BookExchange");
    }
    
    public static IForumThread getPostList() {
        return new ForumThread("BookExchange");
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
        IForumThread pl = be.getPostList();
        
        User u1 = new User("Greta","Garbo","grega","greta@hollywood.com","123456");
        ur.add(u1);
        User u2 = new User("Ingmar","Bergman","ingbe","ingmar@hollywood.com","qwerty");
        ur.add(u2);
        
        Book b1 = new Book("Transformer, Signals and Systems", "PPE", 220, u1,
                "TSS", Book.BookState.FORSALE, new Date(), "This book is only one year old.");
        Book b2 = new Book("Transformer, Signals and Systems", "PPE", 500, u2,
                "TSS", Book.BookState.WANTED, new Date(), "No description");
        bl.add(b1);
        bl.add(b2);
        
        Book b3 = new Book("Vägen till C", "Jan Skansholm", 150, u1,
                "MOP", Book.BookState.WANTED, new Date(), "No description");
        Book b4 = new Book("Vägen till C", "Jan Skansholm", 200, u2,
                "MOP", Book.BookState.FORSALE, new Date(), "No description");
        bl.add(b3);
        bl.add(b4);
        
        Post p1 = new Post("Fan vilken fin gästbok, nästan så att man tror att det är jag som har gjort den :)"
                , new Date(), u1.getFname() + " " + u1.getLname());
        
        Post p2 = new Post("Finns det någon som har en kursbok till Javakursen?"
                , new Date(), u2.getFname() + " " + u2.getLname());
        
        Post p3 = new Post("Du behöver ingen bok till programmeringskurser dumfan!"
                , new Date(), u1.getFname() + " " + u1.getLname());
        
        pl.add(p1);
        pl.add(p2);
        pl.add(p3);
        
    }
}
