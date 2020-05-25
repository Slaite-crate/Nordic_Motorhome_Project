package nordic_motorhome_project.demo.repositories;


import nordic_motorhome_project.demo.models.Extra;

import java.util.List;

public interface IExtraRepository {
    public boolean create(Extra extra);
    public Extra read(int id);
    public List<Extra> readAll();
    public boolean update(Extra extra);
    public boolean delete(int id);
}
