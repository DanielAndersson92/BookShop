package group20.bookexchange.core;

import group20.bookexchange.db.IDAO;
import java.util.List;

/**
 * UserRegistry is the database connection for the User object
 * @author Daniel
 */
public interface IUserRegistry extends IDAO<User,Long>{
    public User getByCID(String cid);
    public Boolean checkCID(String cid);
    public List<User> getByName(String name);
    public List<User> getByFName(String name);
    public List<User> getByLName(String name);
}
