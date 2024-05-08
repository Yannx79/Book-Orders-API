package com.yfunes.bookordersapi.services.impl;

import com.yfunes.bookordersapi.repositories.IGenericRepository;
import com.yfunes.bookordersapi.services.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, K> implements ICRUD<T, K> {

    protected abstract IGenericRepository<T, K> getRepo();

    @Override
    public T save(T t) throws Exception {
        return null;
    }

    @Override
    public T update(T t, K k) throws Exception {
        return null;
    }

    @Override
    public List<T> readAll() throws Exception {
        return null;
    }

    @Override
    public T readById(K k) throws Exception {
        return null;
    }

    @Override
    public void delete(K k) throws Exception {

    }
}
