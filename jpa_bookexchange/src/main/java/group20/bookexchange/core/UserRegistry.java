/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.db.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Daniel
 */
public class UserRegistry extends AbstractDAO<User, Long> implements IUserRegistry{

    public UserRegistry(String puName){
        super(User.class, puName);
    }
    
    @Override
    public List<User> getByCID(String cid) {
        EntityManager em = getEMF().createEntityManager();
        List<User> users;
        TypedQuery<User> q = em.createQuery
                ("SELECT u FROM User u WHERE u.cid = '" + cid + "'", User.class);
        users = q.getResultList();
        em.close();
        return users;
    }
    @Override
    public List<User> getByName(String name) {
        List<User> users = getByFName(name);
        users.addAll(getByLName(name));
        return users;
    }
    @Override
    public List<User> getByLName(String lname) {
        EntityManager em = getEMF().createEntityManager();
        List<User> users;
        TypedQuery<User> q = em.createQuery
                ("SELECT u FROM User u WHERE u.lname = '" + lname + "'", User.class);
        users = q.getResultList();
        em.close();
        return users;
    }
    @Override
    public List<User> getByFName(String fname) {
        EntityManager em = getEMF().createEntityManager();
        List<User> users;
        TypedQuery<User> q = em.createQuery
                ("SELECT u FROM User u WHERE u.fname = '" + fname + "'", User.class);
        users = q.getResultList();
        em.close();
        return users;
    }
}
