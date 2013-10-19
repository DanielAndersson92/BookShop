
package group20.bookexchange.db;

import java.util.List;

public interface IDAO<T, K> {

    public void add(T t);

    public T remove(K id);

    public T update(T t);

    public T find(K id);

    public List<T> getRange(int first, int nItems);

    public int getCount();
}
