package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.models.Motorhome;

import java.util.List;

public interface IMotorhomeRepository {

        public boolean create(Motorhome motorhome);
        public Motorhome read(int id);
        public List<Motorhome> readAll();
        public boolean update(Motorhome motorhome);
        public boolean delete(int id);
}
