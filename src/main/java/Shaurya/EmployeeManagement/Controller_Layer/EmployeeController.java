package Shaurya.EmployeeManagement.Controller_Layer;

import Shaurya.EmployeeManagement.Model.Employee;
import Shaurya.EmployeeManagement.Service_Layer.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getEmp/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        try {
            return employeeService.getEmployeeById(id);
        } catch (Exception e) {
            throw new RuntimeException("Employee DOES NOT EXIST!");
        }
    }

    @PostMapping("/addEmp")
    public void saveEmployee( @RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

    @PutMapping("/updateEmp/{id}")
    public void updateEmpployee(@PathVariable int id, @RequestBody Employee employee){
        employee.setId(id);
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
