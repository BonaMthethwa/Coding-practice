
package za.tut.bl;
import java.sql.*;

public interface TBLInterface<T> {
   public boolean add(T t) throws SQLException; 
   public boolean update(T t)  throws SQLException;
   
}
