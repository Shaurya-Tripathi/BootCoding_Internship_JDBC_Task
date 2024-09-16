package Shaurya.EmployeeManagement.Service_Layer;

import Shaurya.EmployeeManagement.Model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
     Employee getEmployeeById(int id);
     void saveEmployee(Employee employee);
     void updateEmployee(Employee employee);
     void deleteEmployee(int id);

}
