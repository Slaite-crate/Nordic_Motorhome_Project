package nordic_motorhome_project.demo.repositories;


import nordic_motorhome_project.demo.interfaceRepositories.IFeeRepository;
import nordic_motorhome_project.demo.models.Fee;
import nordic_motorhome_project.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeeRepositoryImpl implements IFeeRepository {
    private Connection conn;

    public FeeRepositoryImpl(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Fee fee) {
        boolean result = false;
        try {
            String sql = "insert into fees (fee, price) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, fee.getFee());
            ps.setDouble(2, fee.getPrice());
            int rowsInserted = ps.executeUpdate();


        }catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    @Override
    public Fee read(int id) {
        Fee tempFee = null;
        try {
            String sql = "SELECT * FROM fees WHERE fee_id=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tempFee = new Fee(
                        rs.getInt("fee_id"),
                        rs.getString("fee"),
                        rs.getDouble("price")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempFee;
    }

    @Override
    public List<Fee> readAll() {
        List<Fee> allFee = new ArrayList<>();
        try {
            String sql = "SELECT *\n" +
                    "from fees";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Fee tempFee = new Fee(
                        rs.getInt("fee_id"),
                        rs.getString("fee"),
                        rs.getDouble("price")
                );
                allFee.add(tempFee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allFee;
    }


    @Override
    public boolean update(Fee fee) {
        boolean result = false;
        try {
            String sql = "UPDATE Fees SET Fee = ?, price = ?\n" +
                    "WHERE fee_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,fee.getFee());
            ps.setDouble(2,fee.getPrice());
            ps.setInt(3,fee.getFeeId());

            int rowsInserted = ps.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try {
            String sql = "DELETE FROM Fees WHERE fee_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("An existing fee was deleted successfully!");
                result = true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }


}
