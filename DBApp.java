import java.sql.*;

public class DBApp {
    public static void main(String args[]){
        String[][] employeeArray = EmployeeDao.getAll();

        for (int i=0; i< employeeArray.length; i++){
            for (int j=0; j< 3; j++){
                System.out.println(employeeArray[i][j]);
            }
        }
    }
}