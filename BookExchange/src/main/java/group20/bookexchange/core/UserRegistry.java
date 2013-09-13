/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.utils.AbstractEntityContainer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class UserRegistry extends AbstractEntityContainer<User, Long> implements IUserRegistry{

    public UserRegistry(){
    }
    
    @Override
    public List<User> getByCID(String cid) {
        List<User> found = new ArrayList<>();
        for (User u : getRange(0, getCount())) {
            if (u.getCID().equals(cid)) {
                found.add(u);
            }
        }
        return found;
    }
}
