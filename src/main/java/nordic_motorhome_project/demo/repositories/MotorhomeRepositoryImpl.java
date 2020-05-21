package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.models.Motorhome;
import nordic_motorhome_project.demo.utilities.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotorhomeRepositoryImpl implements IMotorhomeRepository{
    private Connection conn;

    public MotorhomeRepositoryImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Motorhome motorhome) {
        String sqlStatement = "INSERT INTO motorhomes(reg_nr, brand, model, price)VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setString(1, motorhome.getRegNr());
            statement.setString(2, motorhome.getBrand());
            statement.setString(3, motorhome.getModel());
            statement.setDouble(4, motorhome.getPrice());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public Motorhome read(int id) {
        Motorhome motorhomeToReturn = null;
        try {
            String sql = "SELECT * FROM motorhomes WHERE motorhome_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){

            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return motorhomeToReturn;
    }

    @Override
    public List<Motorhome> readAll() {
        List<Motorhome> allMotorhomes = new ArrayList<Motorhome>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM motorhomes");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allMotorhomes;
    }

    @Override
    public boolean update(Motorhome motorhome) {
        String sqlStatement = "UPDATE motorhomes SET motorhome_id=?, reg_nr=?, brand=?, model=?, price=? where motorhome_id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, motorhome.getMotorhomeId());
            statement.setString(2, motorhome.getRegNr());
            statement.setString(3, motorhome.getBrand());
            statement.setString(4, motorhome.getModel());
            statement.setDouble(5, motorhome.getPrice());
            statement.setInt(6, motorhome.getMotorhomeId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        String sqlStatement = "DELETE from motorhomes where motorhome_id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
