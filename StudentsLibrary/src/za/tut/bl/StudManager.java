
package za.tut.bl;
import java.util.*;
import java.sql.*;
import za.ac.tut.entity.Students;

public class StudManager implements StudInterface {
    private Connection connection;
    
    public StudManager(String dbURL, String username, String password) throws SQLException{
        connection=getConnection(dbURL, username, password);
    }
    
    private Connection getConnection(String dbURL, String username, String password) throws SQLException{
        Connection theConnection= DriverManager.getConnection(dbURL, username, password);
        return theConnection;
    }

    @Override
    public void add(Students students, String sqlAddStudent, String sqlAddModule) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Integer id, String sqlDelete) throws SQLException {
        PreparedStatement ps= connection.prepareStatement(sqlDelete);
        ps.setInt(1, id);
        ps.close();
        ps.executeUpdate();
        return true;
    }

    @Override
    public boolean update(Students students, String sqlUpdate) throws SQLException {
        PreparedStatement ps=connection.prepareStatement(sqlUpdate);
        
        ps.setInt(1, students.getId());
        ps.setString(2, students.getName());
        
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public Students get(Integer id, String sqlGetStudent) throws SQLException {
        Students student=null;
        PreparedStatement ps=connection.prepareStatement(sqlGetStudent);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        
        ResultSetMetaData rsmd=rs.getMetaData();
        
        
        return null;
        
    }

    @Override
    public List<Students> getAll(String sqlGetAll) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
