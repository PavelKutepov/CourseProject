package pkutepv.dao.employer_dao;

import org.springframework.stereotype.Service;
import pkutepv.dao.user_dao.User;

import java.util.List;

@Service
public interface EmployeeService {

    void addEmployee(User user, Departament departament);

    void delEmployee(User user);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(int employeeId);
}
