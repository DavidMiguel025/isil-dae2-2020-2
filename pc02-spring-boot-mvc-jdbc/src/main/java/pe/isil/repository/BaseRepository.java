package pe.isil.repository;

import java.util.List;

public interface BaseRepository<T, K> {

    void create(T t);
    void update(T t);
    void delete(T t);

    List<T> findAll();
    T findById(K k);

}
