package DAO;

import java.util.List;

public interface EntityDAO<T> {

    public void create(T entity);
    public List<T> read();
    public void update(T entity);
    public void delete(int id);
}
