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
        boolean result = false;
        try {
            String sql = "insert into brands (brand_name)\n" +
                    "VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, motorhome.getBrand());
            int row = ps.executeUpdate();

            String sql2 = "insert into models (brand_id, model_name, seats, beds, price_per_day)\n" +
                    "values ((SELECT brand_id from brands where brand_name = ?), ?, ?, ?, ?);";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, motorhome.getBrand());
            ps2.setString(2, motorhome.getModel());
            ps2.setInt(3, motorhome.getSeats());
            ps2.setInt(4, motorhome.getBeds());
            ps2.setDouble(5, motorhome.getPrice());
            int row2 = ps2.executeUpdate();

            String sql3 = "insert into motorhomes (model_id, reg_nr)\n" +
                    "VALUES ((SELECT model_id from models where model_name = ?), ?);";
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            ps3.setString(1, motorhome.getModel());
            ps3.setString(2, motorhome.getRegNr());
            int row3 = ps3.executeUpdate();

            if(row > 0 && row2 > 0 && row3 > 0){
                result = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Motorhome read(int id) {
        Motorhome motorhomeToReturn = null;
        try {
            String sql = "SELECT motorhome_id, reg_nr, brand_name, model_name, seats, beds, price_per_day FROM motorhomes INNER JOIN models USING (model_id) INNER JOIN brands USING (brand_id) WHERE motorhome_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                motorhomeToReturn = new Motorhome(
                        rs.getInt("motorhome_id"),
                        rs.getString("reg_nr"),
                        rs.getString("brand_name"),
                        rs.getString("model_name"),
                        rs.getInt("seats"),
                        rs.getInt("beds"),
                        rs.getDouble("price_per_day")
                );
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
            PreparedStatement ps = conn.prepareStatement("SELECT motorhome_id, reg_nr, brand_name, model_name, seats, beds, price_per_day\n" +
                    "from motorhomes inner join models using (model_id) INNER join brands using (brand_id)");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Motorhome tempMotor = new Motorhome(
                        rs.getInt("motorhome_id"),
                        rs.getString("reg_nr"),
                        rs.getString("brand_name"),
                        rs.getString("model_name"),
                        rs.getInt("seats"),
                        rs.getInt("beds"),
                        rs.getDouble("price_per_day")
                );
                allMotorhomes.add(tempMotor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allMotorhomes;
    }

    @Override
    public boolean update(Motorhome motorhome) {
        boolean result = false;
        try {
            String sqlStatement = "UPDATE motorhomes SET motorhome_id=?, reg_nr=?, brand=?, model=?, price=? where motorhome_id=?";
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
        return result;
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
