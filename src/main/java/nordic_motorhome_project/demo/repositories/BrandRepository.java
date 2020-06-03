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

public class BrandRepository implements IMotorhomeRepository { //Pelle
    private Connection conn;

    public BrandRepository() {
        conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Motorhome motorhome) {
        boolean result = false;
        try {
            String sql = "INSERT INTO brands (brand_name) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, motorhome.getBrandName());
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("created new brand");
                result = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Motorhome read(int id) {
        Motorhome brand = new Motorhome();
        try {
            String sql = "SELECT * FROM brands WHERE brand_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                brand.setBrandId(rs.getInt("brand_id"));
                brand.setBrandName(rs.getString("brand_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return brand;
    }

    @Override
    public List<Motorhome> readAll() {
        List<Motorhome> allBrands = new ArrayList<>();
        try {
            String sql = "SELECT * FROM brands ORDER BY brand_id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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
    public boolean update(Motorhome motorhome) {
        boolean result = false;
        try {
            String sql = "UPDATE brands SET brand_name = ? WHERE brand_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, motorhome.getBrandName());
            ps.setInt(2, motorhome.getBrandId());
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
            String sql = "DELETE FROM brands WHERE brand_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
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
    public boolean checkValue(Motorhome motorhome) {
        return false;
    }

    @Override
    public List<Motorhome> readAllBrandsWithModels() {
        List<Motorhome> brandList = new ArrayList<>();
        String sql = "SELECT DISTINCT brand_id, brand_name\n" +
                "FROM models INNER JOIN brands USING (brand_id) ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Motorhome tempMotor = new Motorhome();
                tempMotor.setBrandId(rs.getInt("brand_id"));
                tempMotor.setBrandName(rs.getString("brand_name"));
                brandList.add(tempMotor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return brandList;
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
