package com.getjavajob.repository;

import java.util.List;

public interface IDao<T> {

    List<T> fetchAll();

    T getById(Long id);

    void insert(T entity);

    void deleteAll();

    void deleteById(Long id);

    void update(T entity);
}
