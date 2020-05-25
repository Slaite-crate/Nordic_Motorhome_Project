package nordic_motorhome_project.demo.repositories;
import nordic_motorhome_project.demo.models.Fee;

import java.util.List;

public interface IFeeRepository {
    public boolean create(Fee fee);
    public Fee read(int id);
    public List<Fee> readAll();
    public boolean update(Fee fee);
    public boolean delete(int id);
}
