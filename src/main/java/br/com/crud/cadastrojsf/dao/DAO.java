package br.com.crud.cadastrojsf.dao;

import java.util.List;

public interface DAO<T> {

    public void save(T t);

    public void delete(T t);

    public void update(T t);

    public List<T> getAllUsers();

    public T getUserById(Long id);

}
