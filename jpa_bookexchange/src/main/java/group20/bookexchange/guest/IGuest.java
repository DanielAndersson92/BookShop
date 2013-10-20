/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.guest;

import group20.bookexchange.core.User;
import java.util.List;


/**
 *
 * @author Daniel
 */
public interface IGuest {
    public GuestThread createThread(String title, Post post, User user);
    public void deleteThread(GuestThread thread);
    public List<GuestThread> getThreads();
}
