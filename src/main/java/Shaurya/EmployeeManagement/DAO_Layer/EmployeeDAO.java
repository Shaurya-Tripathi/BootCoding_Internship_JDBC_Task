package Shaurya.EmployeeManagement.DAO_Layer;

import Shaurya.EmployeeManagement.Model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    Employee getEmployeeByID(int id);
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
