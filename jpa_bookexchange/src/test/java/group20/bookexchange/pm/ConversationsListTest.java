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
        Post p = new Post("Hej", new Date(), u1);
        Conversation c = new Conversation(u1,u2,p);
        pc.getConversationsList().add(c);   
    }
}
