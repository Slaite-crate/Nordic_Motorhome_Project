package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.interfaceRepositories.ICrud;
import nordic_motorhome_project.demo.interfaceRepositories.Validator;
import nordic_motorhome_project.demo.models.Customer;
import nordic_motorhome_project.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICrud<Customer> {
    private Connection conn;
    private Validator validator;

    public CustomerRepositoryImpl(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Customer customer) {
        boolean result = false;
        if(checkValue(customer)){
            try {
                String sql = "INSERT INTO customers (first_name, last_name, birth_date, phone_nr, drivers_license) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, customer.getFirstName());
                ps.setString(2, customer.getLastName());
                ps.setDate(3, customer.getBirthDate());
                ps.setString(4, customer.getPhoneNumber());
                ps.setString(5, customer.getDriversLicense());
                int rowsInserted = ps.executeUpdate();

                String sql2 = "INSERT INTO addresses (customer_id, country, zip_code, city, street) VALUES ((SELECT customer_id FROM customers WHERE drivers_license = ?), ?, ?, ?, ?)";
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setString(1, customer.getDriversLicense());
                ps2.setString(2, customer.getCountry());
                ps2.setString(3, customer.getZipCode());
                ps2.setString(4, customer.getCity());
                ps2.setString(5, customer.getStreet());

                int rowsInserted2 = ps2.executeUpdate();
                if (rowsInserted > 0 && rowsInserted2 > 0) {
                    System.out.println("A customer was created successfully!");
                    result = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            result = false;
        }
        return result;
    }

    @Override
    public Customer read(int id) {
        Customer tempCustomer = null;
        try {
            String sql = "SELECT customer_id, first_name, last_name, birth_date, phone_nr, drivers_license, country, zip_code, city, street\n" +
                    "FROM customers INNER JOIN addresses USING (customer_id)\n" +
                    "WHERE customer_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               tempCustomer = new Customer(
                       rs.getInt("customer_id"),
                       rs.getString("first_name"),
                       rs.getString("last_name"),
                       rs.getDate("birth_date"),
                       rs.getString("phone_nr"),
                       rs.getString("drivers_license"),
                       rs.getString("country"),
                       rs.getString("zip_code"),
                       rs.getString("city"),
                       rs.getString("street")
               );
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
            String sql = "SELECT customer_id, first_name, last_name, birth_date, phone_nr, drivers_license, country, zip_code, city, street\n" +
                    "FROM customers INNER JOIN addresses USING (customer_id)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Customer tempCustomer = new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("birth_date"),
                        rs.getString("phone_nr"),
                        rs.getString("drivers_license"),
                        rs.getString("country"),
                        rs.getString("zip_code"),
                        rs.getString("city"),
                        rs.getString("street")
                );
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
            String sql = "UPDATE customers SET first_name = ?, last_name = ?, birth_date = ?, phone_nr = ?, drivers_license = ?\n" +
                    "WHERE customer_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,customer.getFirstName());
            ps.setString(2,customer.getLastName());
            ps.setDate(3,customer.getBirthDate());
            ps.setString(4,customer.getPhoneNumber());
            ps.setString(5,customer.getDriversLicense());
            ps.setInt(6,customer.getCustomerId());

            int rowsInserted = ps.executeUpdate();

            String sql2 = "UPDATE addresses SET country = ?, zip_code = ?, city = ?, street = ?\n" +
                    "WHERE customer_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1,customer.getCountry());
            ps2.setString(2,customer.getZipCode());
            ps2.setString(3,customer.getCity());
            ps2.setString(4,customer.getStreet());
            ps2.setInt(5,customer.getCustomerId());

            int rowsInserted2 = ps2.executeUpdate();
            if (rowsInserted > 0 && rowsInserted2 > 0) {
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

    @Override
    public boolean checkValue(Customer customer) {
        boolean result = false;
        if(validator.isName(customer.getFirstName())
                && validator.isName(customer.getLastName())
                && validator.isPhoneNumber(customer.getPhoneNumber())
                && validator.isDriversLicence(customer.getDriversLicense())
                && validator.isName(customer.getCity())
                && validator.isName(customer.getCountry())
                && validator.isName(customer.getStreet())
                && validator.isInteger(customer.getZipCode())) {
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }
} // by Pelle and Cecilie
