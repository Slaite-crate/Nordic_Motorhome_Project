package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.models.Customer;

import java.util.List;

public interface ICustomerRepository {
    public boolean create(Customer customer);
    public Customer read(int id);
    public List readAll();
    public boolean update(Customer customer);
    public boolean delete(int id);
}
