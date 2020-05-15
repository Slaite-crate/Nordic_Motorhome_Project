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
        boolean result = false;
        try {
            String sql = "INSERT INTO customers (first_name, last_name, address, cpr, phone_nr, drivers_license) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getCpr());
            ps.setString(5, customer.getPhoneNumber());
            ps.setString(6, customer.getDriversLicense());
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A customer was created successfully!");
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Customer read(int id) {
        Customer tempCustomer = new Customer();
        try {
            String sql = "SELECT * FROM customers WHERE customer_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               tempCustomer = new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("cpr"),
                        rs.getString("phone_nr"),
                        rs.getString("drivers_license"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempCustomer;
    }

    @Override
    public List<Customer> readAll() {
        List<Customer> allCustomers = new ArrayList<Customer>();
        try {
            String sql = "SELECT * FROM customers";
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
    public boolean update(Customer customer) {
        boolean result = false;
        try {
            String sql = "UPDATE customers SET first_name=?, last_name=?, address=?, cpr=?, phone_nr=?, drivers_license=? WHERE customer_id =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,customer.getFirstName());
            ps.setString(2,customer.getLastName());
            ps.setString(3,customer.getAddress());
            ps.setString(4,customer.getCpr());
            ps.setString(5,customer.getPhoneNumber());
            ps.setString(6,customer.getDriversLicense());
            ps.setInt(7,customer.getCustomerId());
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("An existing customer was updated successfully!");
                result = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try {
            String sql = "DELETE FROM customers WHERE customer_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("An existing customer was deleted successfully!");
                result = true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
} // by Pelle and Cecilie
