package nordic_motorhome_project.demo.interfaceRepositories;

import nordic_motorhome_project.demo.models.Motorhome;

import java.util.List;

public interface IBrandRepository {

    boolean createBrand(Motorhome motorhome);
    Motorhome readBrand(int id);
    List<Motorhome> readAllBrands();
    boolean updateBrand(Motorhome motorhome);
    boolean deleteBrand(int id);
    List<Motorhome> readAllBrandsWithModels();
}
