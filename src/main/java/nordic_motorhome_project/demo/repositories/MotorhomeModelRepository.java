package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.interfaceRepositories.IMotorhomeRepository;
import nordic_motorhome_project.demo.models.Motorhome;
import nordic_motorhome_project.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotorhomeModelRepository implements IMotorhomeRepository { //Frederic og Natali
    private Connection conn;

    public MotorhomeModelRepository() {
        conn = DatabaseConnectionManager.getDatabaseConnection();
    }


    @Override
    public boolean create(Motorhome motorhome) {
        boolean result = false;
        try {
            String sql = "INSERT INTO models (model_name, seats, beds, price_per_day, brand_id)\n" +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, motorhome.getModelName());
            ps.setInt(2, motorhome.getSeats());
            ps.setInt(3, motorhome.getBeds());
            ps.setDouble(4, motorhome.getPrice());
            ps.setInt(5, motorhome.getBrandId());
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("created worked");
                result = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Motorhome read(int id) {
        Motorhome model = new Motorhome();
        try {
            String sql = "SELECT model_id, model_name, seats, beds, price_per_day, brand_id, brand_name\n" +
                    "FROM models INNER JOIN brands USING (brand_id)\n" +
                    "WHERE model_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.setModelId(rs.getInt("model_id"));
                model.setModelName(rs.getString("model_name"));
                model.setSeats(rs.getInt("seats"));
                model.setBeds(rs.getInt("beds"));
                model.setPrice(rs.getDouble("price_per_day"));
                model.setBrandId(rs.getInt("brand_id"));
                model.setBrandName(rs.getString("brand_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    @Override
    public List<Motorhome> readAll() {
        List<Motorhome> modelList = new ArrayList<Motorhome>();
        try {
            String sql = "SELECT model_id, model_name, seats, beds, price_per_day, brand_id, brand_name\n" +
                    "FROM models INNER JOIN brands USING (brand_id)\n" +
                    "ORDER BY brand_id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Motorhome tempModel = new Motorhome();
                tempModel.setModelId(rs.getInt("model_id"));
                tempModel.setModelName(rs.getString("model_name"));
                tempModel.setSeats(rs.getInt("seats"));
                tempModel.setBeds(rs.getInt("beds"));
                tempModel.setPrice(rs.getDouble("price_per_day"));
                tempModel.setBrandId(rs.getInt("brand_id"));
                tempModel.setBrandName(rs.getString("brand_name"));
                modelList.add(tempModel);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return modelList;
    }

    @Override
    public boolean update(Motorhome motorhome) {
        boolean result = false;
        try {
            String sql = "UPDATE models SET model_name = ?, seats = ?, beds = ?, price_per_day = ?, brand_id = ?\n" +
                    "WHERE model_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, motorhome.getModelName());
            ps.setInt(2, motorhome.getSeats());
            ps.setInt(3, motorhome.getBeds());
            ps.setDouble(4, motorhome.getPrice());
            ps.setInt(5, motorhome.getBrandId());
            ps.setInt(6, motorhome.getModelId());
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
        try {
            String sql = "DELETE FROM models WHERE model_id = ?";
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
        return false;
    }

    @Override
    public List<Motorhome> readAllBrandsWithModels() {
        return null;
    }

    @Override
    public List<Motorhome> readModelsFromBrand(Motorhome brand) {
        List<Motorhome> modelList = new ArrayList<>();
        try {
            String sql = "SELECT model_id, model_name, seats, beds, price_per_day, brand_id " +
                    "FROM models WHERE brand_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, brand.getBrandId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Motorhome tempModel = new Motorhome();
                tempModel.setModelId(rs.getInt("model_id"));
                tempModel.setModelName(rs.getString("model_name"));
                tempModel.setSeats(rs.getInt("seats"));
                tempModel.setBeds(rs.getInt("beds"));
                tempModel.setPrice(rs.getDouble("price_per_day"));
                tempModel.setBrandId(rs.getInt("brand_id"));
                modelList.add(tempModel);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return modelList;
    }

    @Override
    public List<Motorhome> readModelsFromBrand(int id) {
        List<Motorhome> modelList = new ArrayList<>();
        try {
            String sql = "SELECT model_id, model_name, seats, beds, price_per_day, brand_id " +
                    "FROM models WHERE brand_id = (SELECT brand_id FROM models WHERE model_id = (SELECT model_id FROM motorhomes WHERE motorhome_id = ?))";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Motorhome tempModel = new Motorhome();
                tempModel.setModelId(rs.getInt("model_id"));
                tempModel.setModelName(rs.getString("model_name"));
                tempModel.setSeats(rs.getInt("seats"));
                tempModel.setBeds(rs.getInt("beds"));
                tempModel.setPrice(rs.getDouble("price_per_day"));
                tempModel.setBrandId(rs.getInt("brand_id"));
                modelList.add(tempModel);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return modelList;
    }
}
