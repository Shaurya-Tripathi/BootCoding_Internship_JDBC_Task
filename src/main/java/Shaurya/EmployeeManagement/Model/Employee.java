package Shaurya.EmployeeManagement.Model;

public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private double salary;

    public Employee() {
    }

    public Employee(double salary, String email, String last_name, int id, String first_name) {
        this.salary = salary;
        this.email = email;
        this.last_name = last_name;
        this.id = id;
        this.first_name = first_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
