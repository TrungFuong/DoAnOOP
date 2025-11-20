public interface GenericDAO<T, K> {
    boolean insert(T t);

    boolean update(T t);

    boolean delete(K id);

    T findById(K id);

    List<T> findAll();
}
