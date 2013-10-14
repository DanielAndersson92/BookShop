/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.utils.*;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface IUserRegistry extends IEntityContainer<User,Long>{
    public List<User> getByCID(String cid);
}