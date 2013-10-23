package group20.bookexchange.core;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Patrik
 */
public class UserRegistryTest {

    static IBookExchange be;

    @Before
    public void before() {
        be = BookExchangeFactory.getBookExchange(false);
    }
    
    //@Test
    public void testGetRange() {
        IUserRegistry ur = be.getUserRegistry();
        
        for( int i = 0; i < 10 ; i++){
            ur.add(new User(String.valueOf(i), String.valueOf(i), String.valueOf(i), String.valueOf(i), String.valueOf(i)));
        }
        List<User> us = ur.getRange(0, 2);
        assertTrue(us.size() == 2);
    }

    //@Test
    public void testAddUpdateAndRemoveUser() {
        IUserRegistry ur = be.getUserRegistry();

        User u1 = new User("Greta", "Garbo", "Grega", "greta@hollywood.com", "123456");
        ur.add(u1);
        assertTrue(ur.getCount() == 1);

        User u2 = ur.find(u1.getId());
        assertTrue(u2 != u1);
        assertTrue(u2.equals(u1));

        User u = new User(u1.getId(), "updated", u1.getLname(), u1.getCID(), u1.getEmail(), u1.getPassword());
        u1 = ur.update(u);

        assertTrue(u2.equals(u1));
        assertFalse(u2.getFname().equals(u1.getFname()));
        assertTrue(ur.getCount() == 1);

        ur.remove(u1.getId());
        assertTrue(ur.getCount() == 0);
        assertTrue(ur.find(u1.getId()) == null);

        assertTrue(u2.equals(u1));
        assertFalse(u2.getFname().equals(u1.getFname()));
    }

    //@Test
    public void testGetByName() {
        IUserRegistry ur = be.getUserRegistry();
        User u1 = new User("Bo", "Garbo", "bogar", "greta@hollywood.com", "123456");
        User u2 = new User("Lars", "Bo", "bola", "greta@hollywood.com", "qwerty");
        ur.add(u1);
        ur.add(u2);
        List<User> us = ur.getByFName("Bo");
        assertTrue(us.size() == 1);
        us = ur.getByLName("Bo");
        assertTrue(us.size() == 1);
        us = ur.getByName("Bo");
        assertTrue(us.size() == 2);
    }
    @Test
    public void testGetByCID() {
        IUserRegistry ur = be.getUserRegistry();
        User u1 = new User("Bo", "Garbo", "bogar", "greta@hollywood.com","123456");
        User u2 = new User("Lars", "Bo", "bola", "greta@hollywood.com","qwerty");
        ur.add(u1);
        ur.add(u2);
        User us = ur.getByCID("bogar");
    }
}
