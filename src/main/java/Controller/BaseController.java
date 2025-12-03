/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.GenericDAO;
import java.util.List;

public abstract class BaseController<T, K> implements GenericController<T, K> {

    protected final GenericDAO<T, K> dao;

    public BaseController(GenericDAO<T, K> dao) {
        this.dao = dao;
    }

    @Override
    public boolean create(T t) {
        try {
            return dao.Insert(t);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(T t) {
        try {
            return dao.Update(t);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(K id) {
        try {
            return dao.Delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public T get(K id) {
        try {
            return dao.FindById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> getAll() {
        try {
            return dao.FindAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
