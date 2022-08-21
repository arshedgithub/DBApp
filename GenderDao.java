import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenderDao {
    public static List<Gender> getAll(){
        List<Gender> genderList = new ArrayList<Gender>();

        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/euc1", "root", "1234");
            Statement stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * FROM gender");

            while(resultSet.next()){
                Gender gender = new Gender();
                gender.setId(resultSet.getInt("id"));
                gender.setName(resultSet.getString("name"));

                genderList.add(gender);

            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return genderList;
    }

    public static Gender getById(int id){
        Gender gender = new Gender();
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/euc1", "root", "1234");
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM gender where id="+id);
            result.next();
            gender.setId(result.getInt("id"));
            gender.setName(result.getObject("name").toString());
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return gender;
    }
}