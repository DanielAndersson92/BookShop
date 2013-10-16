/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.pm;

import group20.bookexchange.core.User;
import group20.bookexchange.db.IDAO;
import java.util.List;

/**
 *
 * @author Patrik
 */
public interface IConversationsList extends IDAO<Conversation, Long> {
    public List<Conversation> getByUser(User user1);
    public Conversation getByUsers(User u1, User u2);
}
