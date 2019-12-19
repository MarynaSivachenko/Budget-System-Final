package dao;

import java.util.List;

public interface GenericDao<E, K> {
    void create(E object);

    E read(K key);

    void update(E object);

    void delete(E object);

    List<E> readAll();
}
