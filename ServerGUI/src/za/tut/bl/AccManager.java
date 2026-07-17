
package za.tut.bl;
import java.sql.*;
import java.time.Instant;

public class AccManager implements DBInterface, TBLInterface<Account>{
    private Connection connection;

    public AccManager() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    @Override
    public boolean add(Account t) throws SQLException {
        String sql="Insert into acc_tbl values(?,?,?)";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setInt(1, t.getAccountNo());
        ps.setDouble(2, t.getAmount());
        ps.setTimestamp(3, Timestamp.from(Instant.now()));
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean update(Account t) throws SQLException {
        String sql="Update acc_tbl set amount=? where accountNo=?";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setInt(1, t.getAccountNo());
        ps.setDouble(2, t.getAmount());
        ps.executeUpdate();
        ps.close();
        return true;
    }
    
    
    
}
