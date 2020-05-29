package nordic_motorhome_project.demo.interfaceRepositories;

import nordic_motorhome_project.demo.models.Motorhome;

import java.util.List;

public interface IMotorhomeRepository extends ICrud<Motorhome> {
    List<Motorhome> readAllBrandsWithModels();
    List<Motorhome> readModelsFromBrand(Motorhome brand);
    List<Motorhome> readModelsFromBrand(int id);
}
