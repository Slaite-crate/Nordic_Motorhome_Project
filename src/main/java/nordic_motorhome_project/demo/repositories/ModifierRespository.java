package nordic_motorhome_project.demo.repositories;

import nordic_motorhome_project.demo.interfaceRepositories.IModifierRepository;
import nordic_motorhome_project.demo.models.Modifier;
import nordic_motorhome_project.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

        return tempMofifier;
    }

    @Override
    public List<Modifier> readAll() {
        List<Modifier> allModifiers = new ArrayList<>();

        return allModifiers;
    }

    @Override
    public boolean update(Modifier modifier) {
        boolean result = false;

        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;

        return result;
    }
}
