import java.sql.*;

public class CommonDao {
    public static ResultSet get(String qry){
        ResultSet result = null;
        try{
            Connection dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/euc1", "root", "1234");
            Statement stm = dbcon.createStatement();
            result = stm.executeQuery(qry);
        } catch (SQLException ex){
            System.out.println("Can't get result as " + ex.getMessage());
        }
        return result;
    }
}