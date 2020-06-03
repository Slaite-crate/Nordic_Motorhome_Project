package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.interfaceRepositories.IRentalRepository;
import nordic_motorhome_project.demo.models.Customer;
import nordic_motorhome_project.demo.models.Motorhome;
import nordic_motorhome_project.demo.models.Rental;
import nordic_motorhome_project.demo.utilities.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentalRepository implements IRentalRepository { //Pelle

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
    public Motorhome readMotorhome(int id) {
        Motorhome tempMotorhome = new Motorhome();
        String sql = "SELECT motorhome_id,\n" +
                "       reg_nr,\n" +
                "       model_id,\n" +
                "       model_name,\n" +
                "       seats,\n" +
                "       beds,\n" +
                "       price_per_day,\n" +
                "       brand_id,\n" +
                "       brand_name\n" +
                "FROM rentals\n" +
                "         INNER JOIN motorhomes USING (motorhome_id)\n" +
                "         INNER JOIN models USING (model_id)\n" +
                "         INNER JOIN brands USING (brand_id)\n" +
                "WHERE rental_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                tempMotorhome.setMotorhomeId(rs.getInt("motorhome_id"));
                tempMotorhome.setRegNr(rs.getString("reg_nr"));
                tempMotorhome.setModelId(rs.getInt("model_id"));
                tempMotorhome.setModelName(rs.getString("model_name"));
                tempMotorhome.setSeats(rs.getInt("seats"));
                tempMotorhome.setBeds(rs.getInt("beds"));
                tempMotorhome.setPrice(rs.getDouble("price_per_day"));
                tempMotorhome.setBrandId(rs.getInt("brand_id"));
                tempMotorhome.setBrandName(rs.getString("brand_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tempMotorhome;
    }

    @Override
    public Customer readCustomer(int id) {
        Customer tempCustomer = null;
        String sql = "SELECT  customer_id, first_name, last_name, birth_date, phone_nr, drivers_license, country, zip_code, city, street\n" +
                "from rentals INNER JOIN customers USING (customer_id) INNER JOIN addresses USING (customer_id)\n" +
                "WHERE rental_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tempCustomer;
    }

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
