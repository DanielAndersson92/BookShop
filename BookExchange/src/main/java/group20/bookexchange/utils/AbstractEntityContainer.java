package group20.bookexchange.utils;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractEntityContainer<T extends IEntity<K>, K>
        implements IEntityContainer<T, K> {

    private List<T> elems = new ArrayList<>();

    @Override
    public void add(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Null not allowed");
        }
        elems.add(t);
    }

    @Override
    public T remove(K id) {
        T t = find(id);
        if (t != null) {
            elems.remove(t);
        }
        return t;
    }

    @Override
    public void update(T t) {
        T old = find(t.getId());
        if (old != null) {
            elems.remove(old);
        }
        elems.add(t);
    }

    @Override
    public T find(K id) {
        for (T t : elems) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public List<T> getRange(int first, int nItems) {
        // From inclusive, to exclusive
        return elems.subList(first, first + nItems);
    }

    @Override
    public int getCount() {
        return elems.size();
    }
}
