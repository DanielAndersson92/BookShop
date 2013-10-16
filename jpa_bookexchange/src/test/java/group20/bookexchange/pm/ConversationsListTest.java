/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.pm;

import group20.bookexchange.core.BookExchangeFactory;
import group20.bookexchange.core.IBookExchange;
import group20.bookexchange.core.User;
import group20.bookexchange.forum.Post;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Patrik
 */
public class ConversationsListTest {
    static IPMController pc;
    static IBookExchange be;

    @Before
    public void before() {
        pc = PMControllerFactory.getBookList();
        be = BookExchangeFactory.getBookExchange(false);
    }
    @Test
    public void test(){
        User u1 = new User("Bo", "Garbo", "bogar", "greta@hollywood.com", "123456");
        User u2 = new User("Lars", "Bo", "bola", "greta@hollywood.com", "qwerty");
        be.getUserRegistry().add(u1);
        be.getUserRegistry().add(u2);
        Post p1 = new Post("Hej", new Date(), u1);
        Conversation c1 = new Conversation(u1,u2,p1);
        pc.getConversationsList().add(c1);
        
        List<Conversation> cs = pc.getConversationsList().getByUser(u1);
        assertTrue(cs.size() == 1);
        
        
        User u3 = new User("Anders", "Bo", "anbo", "greta@hollywood.com", "qwerty");
        be.getUserRegistry().add(u3);
        Post p2 = new Post("Hejsan", new Date(), u1);
        Conversation c2 = new Conversation(u1,u3,p2);
        pc.getConversationsList().add(c2);
        
        cs = pc.getConversationsList().getByUser(u1);
        assertTrue(cs.size() == 2);
        
        Conversation ctemp = pc.getConversationsList().getByUsers(u1,u2);
        assertTrue(ctemp.equals(c1));
        
        
        assertTrue(ctemp.getPosts().size() == 1);
        ctemp.addPost(new Post("Nämen hej!", new Date(), u2));
        pc.getConversationsList().update(ctemp);
        
        ctemp = pc.getConversationsList().getByUsers(u1,u2);
        assertTrue(ctemp.getPosts().size() == 2);
        
        
        
        
    }
}
