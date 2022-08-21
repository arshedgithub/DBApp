import java.sql.*;

public class EmployeeDao {
    public static String[][] getAll(){

        String[][] employeeArray = null;
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/euc1", "root", "1234");
            Statement stm = con.createStatement(1004,1007);
            ResultSet resultSet = stm.executeQuery("SELECT * FROM employee");
            System.out.println("Connection Established");

            resultSet.last();
            int employeeCount = resultSet.getRow();
            resultSet.beforeFirst();

            employeeArray = new String[employeeCount][4];
            System.out.println(employeeCount);

            int employeeIndex = 0;
            while(resultSet.next()){
                employeeArray[employeeIndex][0] = resultSet.getString("id");
                employeeArray[employeeIndex][1] = resultSet.getString("name");
                employeeArray[employeeIndex][2] = resultSet.getString("nic");
                employeeArray[employeeIndex][3] = resultSet.getString("gender_id");

                employeeIndex++;
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return employeeArray;
    }
}
