package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.interfaceRepositories.IModifierRepository;
import nordic_motorhome_project.demo.models.Modifier;
import nordic_motorhome_project.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModifierRespository implements IModifierRepository {
    private Connection conn;

    public ModifierRespository(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Modifier modifier) {
        boolean result = false;
        try{
            String sql ="INSERT INTO modifiers (modifier_name,modifier) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,modifier.getModifierName());
            ps.setDouble(1,modifier.getModifier());
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A modifier was created successfully!");
                result = true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Modifier read(int id) {
        Modifier tempMofifier = null;
        try{
            String sql ="SELECT * FROM modifiers WHERE modifier_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tempMofifier = new Modifier(
                        rs.getInt("modifier_id"),
                        rs.getString("modifier_name"),
                        rs.getDouble("modifier")
                );
            }
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A modifier was read successfully!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return tempMofifier;
    }

    @Override
    public List<Modifier> readAll() {
        List<Modifier> allModifiers = new ArrayList<>();
        try{
            String sql = "SELECT * FROM modifiers";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Modifier tempModifier = new Modifier(
                        rs.getInt("modifier_id"),
                        rs.getString("modifier_name"),
                        rs.getDouble("modifier")
                );
                allModifiers.add(tempModifier);
            }
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("All modifiers were read successfully!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allModifiers;
    }

    @Override
    public boolean update(Modifier modifier) {
        boolean result = false;

        try{
            String sql = "UPDATE modifiers SET modifier_name = ?, modifier = ? WHERE modifier_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,modifier.getModifierName());
            ps.setDouble(2,modifier.getModifier());
            ps.setInt(3,modifier.getModifierId());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A modifier was updated successfully!");
                result = true;
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try{
            String sql = "DELETE FROM modifiers WHERE modifier_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A modifier was deleted successfully!");
                result = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return result;
    }
}
