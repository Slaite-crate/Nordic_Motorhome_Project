package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.interfaceRepositories.ICrud;
import nordic_motorhome_project.demo.models.Extra;
import nordic_motorhome_project.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExtraRepositoryImpl implements ICrud<Extra> {
    private Connection conn;

    public ExtraRepositoryImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Extra extra) {
        boolean result = false;
        try {
            String sql = "INSERT INTO extra (item, price) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, extra.getItem());
            ps.setDouble(2, extra.getPrice());
            int rowsInserted = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Extra read(int id) {
        Extra tempExtra = null;
        try {
            String sql = "SELECT * FROM extra WHERE extra_id=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tempExtra = new Extra(
                        rs.getInt("extra_id"),
                        rs.getString("item"),
                        rs.getDouble("price")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempExtra;
    }

    @Override
    public List<Extra> readAll() {
        List<Extra> allExtras = new ArrayList<Extra>();
        try {
            String sql = "SELECT *\n" +
                    "FROM extra";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Extra tempExtra = new Extra(
                        rs.getInt("extra_id"),
                        rs.getString("item"),
                        rs.getDouble("price")
                );
                allExtras.add(tempExtra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allExtras;
    }

    @Override
    public boolean update(Extra extra) {
        boolean result = false;
        try {
            String sql = "UPDATE extra SET item = ?, price = ?\n" +
                    "WHERE extra_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, extra.getItem());
            ps.setDouble(2, extra.getPrice());
            ps.setInt(3, extra.getExtraId());
            int rowsInserted = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try {
            String sql = "DELETE FROM extra WHERE extra_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("An existing extra was deleted successfully!");
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
