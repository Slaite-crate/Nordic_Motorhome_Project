package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.interfaceRepositories.IRentalRepository;
import nordic_motorhome_project.demo.models.Customer;
import nordic_motorhome_project.demo.models.Rental;
import nordic_motorhome_project.demo.utilities.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentalRepository implements IRentalRepository {

    private Connection conn;

    public RentalRepository(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Rental rental) {
        return false;
    }

    @Override
    public Rental read(int id) {
        return null;
    }

    @Override
    public List<Rental> readAll() {
        return null;
    }

    @Override
    public boolean update(Rental rental) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Rental> readMotorhomes(int id) {
        return null;
    }

    @Override
    public List<Customer> readAllCustomers() {
        return null;
    }
}
