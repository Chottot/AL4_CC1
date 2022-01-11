package com.chottot.domain.repository;

public interface IRepository<K, T> {

    T get(K member);
    void add(T member);
    void update(T member);
    void remove(K member);

}
