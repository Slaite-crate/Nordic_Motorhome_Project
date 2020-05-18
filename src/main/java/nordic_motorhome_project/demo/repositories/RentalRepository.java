package nordic_motorhome_project.demo.repositories;

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
        List<Rental> rentalList = new ArrayList<Rental>();
        try {
            String sql = "";
            PreparedStatement ps = conn.prepareStatement(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentalList;
    }

    @Override
    public List<Customer> readAllCustomers() {
        List<Customer> customerList = new ArrayList<Customer>();
        try {
            String sql = "SELECT\n" +
                    "    customer_id,\n" +
                    "    first_name,\n" +
                    "    last_name,\n" +
                    "    address,\n" +
                    "    cpr,\n" +
                    "    phone_nr,\n" +
                    "    drivers_license\n" +
                    "FROM\n" +
                    "    customers\n" +
                    "        INNER JOIN\n" +
                    "    rentals USING (customer_id)\n" +
                    "    GROUP BY customer_id";
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
                customerList.add(tempCustomer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean update(Rental rental) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
