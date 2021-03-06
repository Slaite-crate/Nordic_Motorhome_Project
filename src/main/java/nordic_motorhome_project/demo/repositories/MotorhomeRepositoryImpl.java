package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.interfaceRepositories.IMotorhomeRepository;
import nordic_motorhome_project.demo.interfaceRepositories.Validator;
import nordic_motorhome_project.demo.models.Motorhome;
import nordic_motorhome_project.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotorhomeRepositoryImpl implements IMotorhomeRepository {
    private Connection conn;
    private Validator validator;

    public MotorhomeRepositoryImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
        this.validator = new Validator();
    }

    @Override
    public boolean create(Motorhome motorhome) {
        boolean result = false;
        try {
            String sql = "INSERT INTO motorhomes (reg_nr, model_id) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, motorhome.getRegNr());
            ps.setInt(2, motorhome.getModelId());
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("create worked");
                result = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Motorhome read(int id) {
        Motorhome tempMotorhome = new Motorhome();
        String sql = "SELECT motorhome_id, reg_nr, model_id, model_name, seats, beds, price_per_day, brand_id, brand_name\n" +
                "FROM motorhomes INNER JOIN models USING (model_id) INNER JOIN brands USING (brand_id)\n" +
                "WHERE motorhome_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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
    public List<Motorhome> readAll() {
        List<Motorhome> motorhomeList = new ArrayList<>();
        String sql = "SELECT motorhome_id, reg_nr, model_id, model_name, seats, beds, price_per_day, brand_id, brand_name\n" +
                "FROM motorhomes INNER JOIN models USING (model_id) INNER JOIN brands USING (brand_id)\n" +
                "ORDER BY motorhome_id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Motorhome tempMotorhome = new Motorhome();
                tempMotorhome.setMotorhomeId(rs.getInt("motorhome_id"));
                tempMotorhome.setRegNr(rs.getString("reg_nr"));
                tempMotorhome.setModelId(rs.getInt("model_id"));
                tempMotorhome.setModelName(rs.getString("model_name"));
                tempMotorhome.setSeats(rs.getInt("seats"));
                tempMotorhome.setBeds(rs.getInt("beds"));
                tempMotorhome.setPrice(rs.getDouble("price_per_day"));
                tempMotorhome.setBrandId(rs.getInt("brand_id"));
                tempMotorhome.setBrandName(rs.getString("brand_name"));
                motorhomeList.add(tempMotorhome);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return motorhomeList;
    }

    @Override
    public boolean update(Motorhome motorhome) {
        boolean result = false;
        String sql = "UPDATE motorhomes SET reg_nr = ?, model_id = ? " +
                "WHERE motorhome_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, motorhome.getRegNr());
            ps.setInt(2, motorhome.getModelId());
            ps.setInt(3, motorhome.getMotorhomeId());
            int row = ps.executeUpdate();
            if (row > 0) {
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
        String sql = "DELETE FROM motorhomes WHERE motorhome_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("delete worked");
                result = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean checkValue(Motorhome motorhome) {
        boolean result;
        if (validator.isNumberPlate(motorhome.getRegNr())
                && validator.isName(motorhome.getModelName())
                && validator.isName(motorhome.getBrandName())
                && validator.isPrice(Double.toString(motorhome.getPrice()))
                && validator.isInteger(Integer.toString(motorhome.getSeats()))
                && validator.isInteger(Integer.toString(motorhome.getBeds()))) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public List<Motorhome> readAllBrandsWithModels() {
        return null;
    }

    @Override
    public List<Motorhome> readModelsFromBrand(Motorhome brand) {
        return null;
    }

    @Override
    public List<Motorhome> readModelsFromBrand(int id) {
        return null;
    }
}

