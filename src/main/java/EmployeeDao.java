import java.util.List;

public interface EmployeeDao {
    void saveEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);

}