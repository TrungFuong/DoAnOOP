public interface GenericService<T, K> {
    boolean create(T t);

    boolean update(T t);

    boolean delete(K id);

    T get(K id);

    List<T> getAll();
}
