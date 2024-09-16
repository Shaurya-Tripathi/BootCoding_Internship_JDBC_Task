package Shaurya.EmployeeManagement.DAO_Layer;

import Shaurya.EmployeeManagement.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DAOImp implements EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql,(rs, rowNum) -> mapRowToEmployee(rs));
    }


    @Override
    public Employee getEmployeeByID(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},(rs,rowNum)->mapRowToEmployee(rs));
    }

    @Override
    public void saveEmployee(Employee employee) {
        String sql = "INSERT INTO employee(first_name,last_name,email,salary) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,employee.getFirst_name(),employee.getLast_name(),employee.getEmail(),employee.getSalary());
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET first_name = ?, last_name = ?, email = ?, salary = ? WHERE id= ?";
        jdbcTemplate.update(sql,employee.getFirst_name(),employee.getLast_name(),employee.getEmail(),employee.getSalary(),employee.getId());
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM EMPLOYEE WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setFirst_name(rs.getString("first_name"));
        employee.setLast_name(rs.getString("last_name"));
        employee.setEmail(rs.getString("email"));
        employee.setSalary(rs.getDouble("salary"));
        return employee;
    }
}
