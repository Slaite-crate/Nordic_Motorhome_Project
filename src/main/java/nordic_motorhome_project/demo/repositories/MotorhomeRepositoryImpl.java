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
    public boolean createMotorhome(Motorhome motorhome) {
        return false;
    }

    @Override
    public boolean createModel(Motorhome motorhome) {
        return false;
    }

    @Override
    public boolean createBrand(Motorhome motorhome) {
        boolean result = false;
        try {
            String sql = "INSERT INTO brands (brand_name) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,motorhome.getBrandName());
            int row = ps.executeUpdate();
            if (row > 0){
                System.out.println("created new brand");
                result = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Motorhome readMotorhome(int id) {
        return null;
    }

    @Override
    public Motorhome readModel(int id) {
        return null;
    }

    @Override
    public Motorhome readBrand(int id) {
        Motorhome brand = new Motorhome();
        try {
            String sql = "SELECT * FROM brands WHERE brand_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                brand.setBrandId(rs.getInt("brand_id"));
                brand.setBrandName(rs.getString("brand_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return brand;
    }

    @Override
    public List<Motorhome> readAllMotorhomes() {
        return null;
    }

    @Override
    public List<Motorhome> readAllModels() {
        List<Motorhome> modelList = new ArrayList<Motorhome>();
        try {
            String sql = "SELECT model_id, model_name, seats, beds, price_per_day, brand_id, brand_name\n" +
                    "FROM models INNER JOIN brands USING (brand_id)\n" +
                    "ORDER BY brand_id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
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
    public List<Motorhome> readAllBrands() {
        List<Motorhome> allBrands = new ArrayList<>();
        try {
            String sql = "SELECT * FROM brands ORDER BY brand_id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Motorhome tempBrand = new Motorhome();
                tempBrand.setBrandId(rs.getInt("brand_id"));
                tempBrand.setBrandName(rs.getString("brand_name"));
                allBrands.add(tempBrand);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allBrands;
    }

    @Override
    public boolean updateMotorhome(Motorhome motorhome) {
        return false;
    }

    @Override
    public boolean updateModel(Motorhome motorhome) {
        return false;
    }

    @Override
    public boolean updateBrand(Motorhome motorhome) {
        boolean result = false;
        try {
            String sql = "UPDATE brands SET brand_name = ? WHERE brand_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, motorhome.getBrandName());
            ps.setInt(2, motorhome.getBrandId());
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
    public boolean deleteMotorhome(int id) {
        return false;
    }

    @Override
    public boolean deleteModel(int id) {
        return false;
    }

    @Override
    public boolean deleteBrand(int id) {
        boolean result = false;
        try {
            String sql = "DELETE FROM brands WHERE brand_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
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
}
