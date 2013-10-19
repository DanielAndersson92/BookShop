package group20.bookexchange.utils;

import java.io.Serializable;

public interface IEntity<K> extends Serializable  {
    public K getId();
}
