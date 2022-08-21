import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public static List<Employee> getAll(){

        List<Employee> employeeList = new ArrayList<Employee>();

        try{
            String qry = "SELECT * FROM employee";
            ResultSet resultSet = CommonDao.get(qry);

            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setGender(GenderDao.getById(resultSet.getInt("gender_id")));

                employeeList.add(employee);
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return employeeList;
    }
}
