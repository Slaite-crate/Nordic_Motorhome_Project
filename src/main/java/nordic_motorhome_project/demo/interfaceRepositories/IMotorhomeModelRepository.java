package nordic_motorhome_project.demo.interfaceRepositories;

import nordic_motorhome_project.demo.models.Motorhome;

import java.util.List;

public interface IMotorhomeModelRepository {
    boolean createModel(Motorhome motorhome);
    Motorhome readModel(int id);
    List<Motorhome> readAllModels();
    boolean updateModel(Motorhome motorhome);
    boolean deleteModel(int id);
    List<Motorhome> readModelsFromBrand(Motorhome brand);
}
