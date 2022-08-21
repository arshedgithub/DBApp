import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenderDao {
    public static List<Gender> getAll(){
        List<Gender> genderList = new ArrayList<Gender>();

        try{
            ResultSet result = CommonDao.get("SELECT * FROM gender");

            while(result.next()){
                Gender gender = new Gender();
                gender.setId(result.getInt("id"));
                gender.setName(result.getString("name"));

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
            String qry = "SELECT * FROM gender where id="+id;
            ResultSet result = CommonDao.get(qry);
            result.next();
            gender.setId(result.getInt("id"));
            gender.setName(result.getObject("name").toString());
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return gender;
    }
}