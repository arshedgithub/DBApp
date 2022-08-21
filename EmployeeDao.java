import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public static List<Employee> getAll(){

        List<Employee> employeeArray = new ArrayList<Employee>();
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/euc1", "root", "1234");
            Statement stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * FROM employee");

            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setGender(resultSet.getInt("gender_id"));
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return employeeArray;
    }
}
