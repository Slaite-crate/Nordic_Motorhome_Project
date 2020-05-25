package nordic_motorhome_project.demo.interfaceRepositories;

import nordic_motorhome_project.demo.models.Fee;

import java.util.List;

public interface IFeeRepository {
    boolean create(Fee fee);
    Fee read(int id);
    List<Fee> readAll();
    boolean update(Fee fee);
    boolean delete(int id);
}
