/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.pm;

import group20.bookexchange.core.User;
import group20.bookexchange.db.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Patrik
 */
public class ConversationsList extends AbstractDAO<Conversation, Long> implements IConversationsList{
    
    public ConversationsList(String puName){
        super(Conversation.class, puName);
    }

    @Override
    public List<Conversation> getByUser(User user1) {
        EntityManager em = getEMF().createEntityManager();
        List<Conversation> conversations;
        TypedQuery<Conversation> q = em.createQuery
                ("SELECT c FROM Conversation AS c WHERE :user MEMBER OF c.users", Conversation.class).
                setParameter("user", user1);
        conversations = q.getResultList();
        em.close();
        return conversations;
    }

    @Override
    public List<Conversation> getByUsers(User u1, User u2) {
        EntityManager em = getEMF().createEntityManager();
        List<Conversation> conversations;
        TypedQuery<Conversation> q = em.createQuery
                ("SELECT c FROM Conversation AS c WHERE :user1 MEMBER OF c.users"
                + "AND :user2 MEMBER OF c.users", Conversation.class).
                setParameter("user1", u1)
                .setParameter("user2", u2);
        conversations = q.getResultList();
        em.close();
        return conversations;    }
    
}
