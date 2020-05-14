package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.models.Customer;
import nordic_motorhome_project.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository{
    private Connection conn;

    public CustomerRepositoryImpl(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Customer customer) {

        return false;
    }

    @Override
    public Customer read(int id) {
        return null;
    }

    @Override
    public List readAll() {
        String sql = "SELECT * FROM customers";
        List<Customer> allCustomers = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Customer tempCustomer = new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("cpr"),
                        rs.getString("phone_nr"),
                        rs.getString("drivers_license"));
                allCustomers.add(tempCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomers;
    }

    @Override
    public boolean update(int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
} // by Pelle and Cecilie
