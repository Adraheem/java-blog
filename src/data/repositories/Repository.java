package data.repositories;

import data.models.Post;

import java.util.List;

public interface Repository<T> {
    T save(T t);
    T findById(int id);
    List<T> findAll();
    long count();
    void delete(T t);
    void delete(int id);
}
