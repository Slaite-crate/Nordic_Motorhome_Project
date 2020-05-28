package nordic_motorhome_project.demo.interfaceRepositories;

import java.util.List;

public interface ICrud<T> {
    boolean create(T t);
    T read(int id);
    List<T> readAll();
    boolean update(T t);
    boolean delete(int id);
}
