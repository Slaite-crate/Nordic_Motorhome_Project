package nordic_motorhome_project.demo.interfaceRepositories;

import nordic_motorhome_project.demo.models.Customer;
import nordic_motorhome_project.demo.models.Motorhome;
import nordic_motorhome_project.demo.models.Rental;

import java.util.List;

public interface IRentalRepository {
    boolean create(Rental rental);
    Rental read(int id);
    List<Rental> readAll();
    List<Rental> readAll(String order);
    boolean update(Rental rental);
    boolean delete(int id);
    List<Motorhome> readAllMotorhomes();
    List<Customer> readAllCustomers();
}
