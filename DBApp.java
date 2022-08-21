import java.util.List;

public class DBApp {
    public static void main(String args[]){
        List<Employee> employeeList = EmployeeDao.getAll();

        for (Employee emp:employeeList){
            System.out.println(emp.getId());
            System.out.println(emp.getName());
            System.out.println(emp.getGender());
        }
    }
}