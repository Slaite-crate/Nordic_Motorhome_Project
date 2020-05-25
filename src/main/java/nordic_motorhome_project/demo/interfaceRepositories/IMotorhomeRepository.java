package nordic_motorhome_project.demo.interfaceRepositories;

import nordic_motorhome_project.demo.models.Motorhome;

import java.util.List;

public interface IMotorhomeRepository {

        boolean createMotorhome(Motorhome motorhome);
        Motorhome readMotorhome(int id);
        List<Motorhome> readAllMotorhomes();
        boolean updateMotorhome(Motorhome motorhome);
        boolean deleteMotorhome(int id);

}
