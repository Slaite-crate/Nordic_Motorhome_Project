package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.interfaceRepositories.IRentalRepository;
import nordic_motorhome_project.demo.models.Customer;
import nordic_motorhome_project.demo.models.Motorhome;
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
        boolean result = false;
        String sql = "INSERT INTO rentals (customer_id, motorhome_id, pickup_date, dropoff_date)\n" +
                "VALUES (?, ?, ? ,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, rental.getCustomerId());
            ps.setInt(2, rental.getMotorhomeId());
            ps.setDate(3, rental.getPickupDate());
            ps.setDate(4, rental.getDropoffDate());
            int row = ps.executeUpdate();
            if (row > 0){
                System.out.println("create worked");
                result = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Rental read(int id) {
        Rental tempRental = new Rental();
        String sql = "SELECT rental_id, customer_id, motorhome_id, pickup_date, dropoff_date\n" +
                "FROM rentals\n" +
                "WHERE rental_id = ?\n" +
                "ORDER BY rental_id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                tempRental.setRentalId(rs.getInt("rental_id"));
                tempRental.setCustomerId(rs.getInt("customer_id"));
                tempRental.setMotorhomeId(rs.getInt("motorhome_id"));
                tempRental.setPickupDate(rs.getDate("pickup_date"));
                tempRental.setDropoffDate(rs.getDate("dropoff_date"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tempRental;
    }

    @Override
    public List<Rental> readAll() {
        List<Rental> rentalList = new ArrayList<>();
        String sql = "SELECT rental_id, customer_id, motorhome_id, pickup_date, dropoff_date\n" +
                "FROM rentals\n" +
                "ORDER BY rental_id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Rental tempRental = new Rental();
                tempRental.setRentalId(rs.getInt("rental_id"));
                tempRental.setCustomerId(rs.getInt("customer_id"));
                tempRental.setMotorhomeId(rs.getInt("motorhome_id"));
                tempRental.setPickupDate(rs.getDate("pickup_date"));
                tempRental.setDropoffDate(rs.getDate("dropoff_date"));
                rentalList.add(tempRental);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentalList;
    }

    public List<Rental> readAll(String order) {
        List<Rental> rentalList = new ArrayList<>();
        String sql = sqlThingy(order);
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Rental tempRental = new Rental();
                tempRental.setRentalId(rs.getInt("rental_id"));
                tempRental.setCustomerId(rs.getInt("customer_id"));
                tempRental.setMotorhomeId(rs.getInt("motorhome_id"));
                tempRental.setPickupDate(rs.getDate("pickup_date"));
                tempRental.setDropoffDate(rs.getDate("dropoff_date"));
                rentalList.add(tempRental);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentalList;
    }

    @Override
    public boolean update(Rental rental) {
        boolean result = false;
        String sql = "UPDATE rentals\n" +
                "SET customer_id = ?, motorhome_id = ?, pickup_date = ?, dropoff_date = ?\n" +
                "WHERE rental_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, rental.getCustomerId());
            ps.setInt(2, rental.getMotorhomeId());
            ps.setDate(3, rental.getPickupDate());
            ps.setDate(4, rental.getDropoffDate());
            ps.setInt(5, rental.getRentalId());
            int row = ps.executeUpdate();
            if (row > 0){
                System.out.println("update worked");
                result = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String sql = "DELETE FROM rentals\n" +
                "WHERE rental_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int row = ps.executeUpdate();
            if (row > 0){
                System.out.println("delete worked");
                result = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean checkValue(Rental rental) {
        return false;
    }

    @Override
    public List<Motorhome> readAllMotorhomes() {
        return null;
    }

    @Override
    public List<Customer> readAllCustomers() {
        return null;
    }

    //
    private String sqlThingy(String order){
        String result = "SELECT rental_id, customer_id, motorhome_id, pickup_date, dropoff_date\n" +
                "FROM rentals";
        if (order.equals("pickup_date")){
            result = "SELECT rental_id, customer_id, motorhome_id, pickup_date, dropoff_date\n" +
                    "FROM rentals\n" +
                    "ORDER BY pickup_date";
        }
        if (order.equals("dropoff_date")){
            result = "SELECT rental_id, customer_id, motorhome_id, pickup_date, dropoff_date\n" +
                    "FROM rentals\n" +
                    "ORDER BY dropoff_date";
        }
        if (order.equals("customer_id")) {
            result = "SELECT rental_id, customer_id, motorhome_id, pickup_date, dropoff_date\n" +
                    "FROM rentals\n" +
                    "ORDER BY customer_id";
        }
        if (order.equals("motorhome_id")) {
            result = "SELECT rental_id, customer_id, motorhome_id, pickup_date, dropoff_date\n" +
                    "FROM rentals\n" +
                    "ORDER BY motorhome_id";
        }
        return result;
    }
}
