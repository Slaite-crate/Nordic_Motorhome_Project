package nordic_motorhome_project.demo.interfaceRepositories;

import nordic_motorhome_project.demo.models.Customer;

import java.util.List;

public interface ICustomerRepository {
    boolean create(Customer customer);
    Customer read(int id);
    List<Customer> readAll();
    boolean update(Customer customer);
    boolean delete(int id);
}
