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
        return null;
    }

    @Override
    public List<Motorhome> readAllMotorhomes() {
        return null;
    }

    @Override
    public List<Motorhome> readAllModels() {
        return null;
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
        return false;
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
        return false;
    }
}
