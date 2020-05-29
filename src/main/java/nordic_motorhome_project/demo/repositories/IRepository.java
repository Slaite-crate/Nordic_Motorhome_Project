package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.models.Motorhome;

import java.util.List;

public interface IRepository {
    boolean create(Object obj);
    Object read(int id);
    List<Object> readAll();
    boolean update(Object object);
    boolean delete(int id);
}
