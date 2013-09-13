
package group20.bookexchange.utils;

import java.util.Comparator;
import java.util.List;

/**
 * Basic contract for containers of Products, Customers, etc
 * 
 * T is type of elements in container
 * K is type of id (primary key)
 * 
 * @author hajo
 */
public interface IEntityContainer<T extends IEntity<K>, K> {

    public void add(T t);

    public T remove(K id);

    public void update(T t);

    public T find(K id);

    public List<T> getRange(int first, int nItems);

    public int getCount();
}
