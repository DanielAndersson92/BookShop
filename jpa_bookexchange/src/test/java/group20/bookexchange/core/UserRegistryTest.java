package group20.bookexchange.core;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


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
            ur.add(new User(String.valueOf(i), String.valueOf(i), String.valueOf(i), String.valueOf(i)));
        }
        List<User> us = ur.getRange(0, 2);
        assertTrue(us.size() == 2);
    }

    //@Test
    public void testAddUpdateAndRemoveUser() {
        IUserRegistry ur = be.getUserRegistry();

        User u1 = new User("Greta", "Garbo", "Grega", "greta@hollywood.com");
        ur.add(u1);
        assertTrue(ur.getCount() == 1);

        User u2 = ur.find(u1.getId());
        // Not same transaction
        assertTrue(u2 != u1);
        // Equal by value
        assertTrue(u2.equals(u1));

        User u = new User(u1.getId(), "updated", u1.getLname(), u1.getCID(), u1.getEmail());
        u1 = ur.update(u);
        /*
         * Id NOT changed here we have two Products with
         * same id but different state! 
         * Seems to be no single simple solution to this..?!
         */
        assertTrue(u2.equals(u1));
        assertFalse(u2.getFname().equals(u1.getFname()));
        assertTrue(ur.getCount() == 1);

        ur.remove(u1.getId());
        assertTrue(ur.getCount() == 0);
        assertTrue(ur.find(u1.getId()) == null);

        // No change in program (but deleted from database)
        assertTrue(u2.equals(u1));
        assertFalse(u2.getFname().equals(u1.getFname()));
    }

    //@Test
    public void testGetByName() {
        IUserRegistry ur = be.getUserRegistry();
        User u1 = new User("Bo", "Garbo", "bogar", "greta@hollywood.com");
        User u2 = new User("Lars", "Bo", "bola", "greta@hollywood.com");
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
        User u1 = new User("Bo", "Garbo", "bogar", "greta@hollywood.com");
        User u2 = new User("Lars", "Bo", "bola", "greta@hollywood.com");
        ur.add(u1);
        ur.add(u2);
        User us = ur.getByCID("bogar");
        //assertTrue(us.size() == 1);
    }
}
