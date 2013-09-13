/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.forum;

import group20.bookexchange.core.User;
import java.util.List;


/**
 *
 * @author Daniel
 */
public interface IForum {
    public ForumThread createThread(String title, Post post, User user);
    public void deleteThread(ForumThread thread);
    public List<ForumThread> getThreads();
}
