import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBApp1 {
    public static void main(String args[]){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/euc1", "root", "1234");
            Statement stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * FROM employee");
            System.out.println("Connection Established");

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String nic = resultSet.getString("nic");
                int gender_id = resultSet.getInt("gender_id");
            
                System.out.println(id + "\t" + name + "\t" + nic + "\t" + gender_id );
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}