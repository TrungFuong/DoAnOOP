package DAO;

import java.util.List;

public interface GenericDAO<T, K> {
    boolean Insert(T t);

    boolean Update(T t);

    boolean Delete(K id);

    T FindById(K id);

    List<T> FindAll();
}