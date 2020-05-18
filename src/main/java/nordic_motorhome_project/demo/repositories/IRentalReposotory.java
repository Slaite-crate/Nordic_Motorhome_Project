package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.models.Rental;

import java.util.List;

public interface IRentalReposotory {
    boolean create(Rental rental);
    Rental read(int id);
    List<Rental> readAll(int id);
    boolean update(Rental rental);
    boolean delete(int id);
}
