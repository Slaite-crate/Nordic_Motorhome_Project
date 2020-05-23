package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.models.Motorhome;

import java.util.List;

public interface IMotorhomeRepository {

        boolean createMotorhome(Motorhome motorhome);
        boolean createModel(Motorhome motorhome);
        boolean createBrand(Motorhome motorhome);
        Motorhome readMotorhome(int id);
        Motorhome readModel(int id);
        Motorhome readBrand(int id);
        List<Motorhome> readAllMotorhomes();
        List<Motorhome> readAllModels();
        List<Motorhome> readAllBrands();
        boolean updateMotorhome(Motorhome motorhome);
        boolean updateModel(Motorhome motorhome);
        boolean updateBrand(Motorhome motorhome);
        boolean deleteMotorhome(int id);
        boolean deleteModel(int id);
        boolean deleteBrand(int id);

}
