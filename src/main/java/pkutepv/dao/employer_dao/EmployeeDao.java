package pkutepv.dao.employer_dao;

import pkutepv.dao.user_dao.User;

import java.util.List;

public interface EmployeeDao {
    void addEmployee(User user, Departament departament);

    void delEmployee(User user);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(int employeeId);
}
