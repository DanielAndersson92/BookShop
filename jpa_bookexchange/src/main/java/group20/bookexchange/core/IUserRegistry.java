/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.db.IDAO;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface IUserRegistry extends IDAO<User,Long>{
    public List<User> getByCID(String cid);
    public List<User> getByName(String name);
    public List<User> getByFName(String name);
    public List<User> getByLName(String name);
}
