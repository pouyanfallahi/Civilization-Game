package ir.civilization.holder;

import java.util.Collection;

public interface ObjectHolder<E> {

    void cache(E e);
    void remove(E e);
    void clearCache();
    Collection<E> getAll();
    boolean isPresent(E e);

}
