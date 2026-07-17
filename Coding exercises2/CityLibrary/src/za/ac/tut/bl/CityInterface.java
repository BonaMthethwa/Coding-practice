
package za.ac.tut.bl;
import java.sql.*;
import java.util.*;
import za.ac.tut.entity.City;


public interface CityInterface {
    public void add(City city, String sqlAddCity, String sqlAddMayor) throws SQLException;
    public boolean delete(Integer id, String sql) throws SQLException;
    public boolean update(City city, String sql) throws SQLException;
    public City get(Integer id, String sql) throws SQLException;
    public List<City> getAll(String sql) throws SQLException;
}
