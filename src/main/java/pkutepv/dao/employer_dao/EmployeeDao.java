package pkutepv.dao.employer_dao;

import pkutepv.dao.user_dao.User;

public interface EmployeeDao {
void addEmployee(User user, Departament departament);
void delEmployee(User user);

}
