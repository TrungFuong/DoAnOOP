package Controller;

import java.util.List;

public interface GenericController<T, K> {
    boolean create(T t);

    boolean update(T t);

    boolean delete(K id);

    T get(K id);

    List<T> getAll();
}
