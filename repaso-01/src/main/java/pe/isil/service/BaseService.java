package pe.isil.service;

import java.util.List;

public interface BaseService<T, K> {

    void create(T t);
    void update(T t);
    void delete(T t);

    List<T> findAll();
    T findById(K k);

}
