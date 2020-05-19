package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.models.Customer;
import nordic_motorhome_project.demo.models.Motorhome;
import nordic_motorhome_project.demo.models.Rental;

import java.util.List;

public interface IRentalRepository {
    boolean create(Rental rental);
    Rental read(int id);
    List<Rental> readAll();
    List<Customer> readAllCustomers();
    boolean update(Rental rental);
    boolean delete(int id);
    List<Motorhome> readMotorhomes(int id);
}
