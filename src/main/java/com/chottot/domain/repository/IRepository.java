package com.chottot.domain.repository;

import java.util.List;

public interface IRepository<K, T> {

    T get(K key);
    void add(T key);
    void update(T key);
    void remove(K key);
    List<T> getAll();

}
