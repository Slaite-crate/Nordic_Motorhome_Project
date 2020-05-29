package nordic_motorhome_project.demo.interfaceRepositories;

import nordic_motorhome_project.demo.models.Customer;
import nordic_motorhome_project.demo.models.Motorhome;
import nordic_motorhome_project.demo.models.Rental;

import java.util.List;

public interface IRentalRepository extends ICrud<Rental>{
    List<Rental> readAll(String order);
    List<Motorhome> readAllMotorhomes();
    List<Customer> readAllCustomers();
}
