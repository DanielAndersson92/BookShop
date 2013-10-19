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
public interface IConversationsList extends IDAO<PMConversation, Long> {
    public List<PMConversation> getByUser(User user1);
    public PMConversation getByUsers(User u1, User u2);
}
