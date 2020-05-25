package nordic_motorhome_project.demo.interfaceRepositories;

import nordic_motorhome_project.demo.models.Extra;

import java.util.List;

public interface IExtraRepository {
    boolean create(Extra extra);
    Extra read(int id);
    List<Extra> readAll();
    boolean update(Extra extra);
    boolean delete(int id);
}
