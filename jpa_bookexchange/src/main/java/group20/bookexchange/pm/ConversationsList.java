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
public class ConversationsList extends AbstractDAO<PMConversation, Long> implements IConversationsList{
    
    public ConversationsList(String puName){
        super(PMConversation.class, puName);
    }

    @Override
    public List<PMConversation> getByUser(User user1) {
        EntityManager em = getEMF().createEntityManager();
        List<PMConversation> conversations;
        TypedQuery<PMConversation> q = em.createQuery
                ("SELECT c FROM PMConversation c WHERE :user MEMBER OF c.users", PMConversation.class).
                setParameter("user", user1);
        conversations = q.getResultList();
        em.close();
        return conversations;
    }

    @Override
    public PMConversation getByUsers(User u1, User u2) {
        EntityManager em = getEMF().createEntityManager();
        PMConversation conversation;
        TypedQuery<PMConversation> q = em.createQuery
                ("SELECT c FROM PMConversation c WHERE :user1 MEMBER OF c.users "
                + "AND :user2 MEMBER OF c.users", PMConversation.class).
                setParameter("user1", u1).setParameter("user2", u2);
        conversation = q.getSingleResult();
        em.close();
        return conversation;    }
    
}
