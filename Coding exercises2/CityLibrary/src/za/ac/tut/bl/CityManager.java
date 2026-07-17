
package za.ac.tut.bl;
import java.util.*;
import java.sql.*;
import za.ac.tut.entity.City;
import za.ac.tut.entity.Mayor;


public class CityManager implements CityInterface {
    private Connection connection;
    
    public CityManager(String dbURL, String username, String password) throws SQLException{
        connection=getConnection(dbURL, username, password);
    }
    
    private Connection getConnection(String dbURL, String username, String password) throws SQLException{
        Connection theConnection= DriverManager.getConnection(dbURL, username, password);
        return theConnection;
    }

    @Override
    public void add(City city, String sqlAddCity, String sqlAddMayor) throws SQLException {
        PreparedStatement ps1= connection.prepareStatement(sqlAddCity);
        PreparedStatement ps2=connection.prepareStatement(sqlAddMayor);
        
        ps1.setInt(1, city.getId());
        ps1.setString(2, city.getName());
        ps1.setInt(3, city.getPopulation());
        
        ps2.setInt(1, city.getMayor().getId());
        ps2.setString(2, city.getMayor().getName());
        ps2.setString(3, city.getMayor().getSurname());
        ps2.setInt(4, city.getId());
        
        ps1.executeUpdate();
        ps2.executeUpdate();
        
        ps1.close();
        ps2.close();
    }
    @Override
    public boolean delete(Integer id, String sql) throws SQLException {
        PreparedStatement ps =connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.close();
        ps.executeUpdate();
        return true;
    }

    @Override
    public boolean update(City city, String sql) throws SQLException {
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setString(1, city.getMayor().getName());
        ps.setString(2, city.getMayor().getSurname());
        ps.setInt(3, city.getId());
        ps.close();
        ps.executeUpdate();
        return true;
    }

    @Override
    public City get(Integer id, String sql) throws SQLException {
        PreparedStatement ps= connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        City city=null;
        
        if(rs.next()){
            Integer cId=rs.getInt("Id");
            String name=rs.getString("Name");
            Integer population=rs.getInt("Population");
            Integer mId=rs.getInt("mayor_id");
            String mName=rs.getString("mayor_name");
            String mSurname=rs.getString("mayor_surname");
            
            Mayor mayor=new Mayor(mId, mName, mSurname);
            city=new City(cId, name, population, mayor);
          
        }
        ps.close();
        return city;
    }

    @Override
    public List<City> getAll(String sql) throws SQLException {
        List<City> cities=new ArrayList<>();
        PreparedStatement ps=connection.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            Integer id=rs.getInt("Id");
            String name=rs.getString("Name");
            Integer population=rs.getInt("Population");
            Integer mId=rs.getInt("mayor_id");
            String mName= rs.getString("mayor_name");
            String mSurname= rs.getString("mayor_surname");
            
            Mayor mayor=new Mayor(mId, mName, mSurname);
            City city=new City(id, name, population,mayor);
            cities.add(city);
        }
        ps.close();
        return cities;
    }
    
    
    
}
