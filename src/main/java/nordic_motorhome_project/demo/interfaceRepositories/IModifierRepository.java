package nordic_motorhome_project.demo.interfaceRepositories;

import nordic_motorhome_project.demo.models.Modifier;

import java.util.List;

public interface IModifierRepository {
    boolean create(Modifier modifier);
    Modifier read(int id);
    List<Modifier> readAll();
    boolean update(Modifier modifier);
    boolean delete(int id);
}
