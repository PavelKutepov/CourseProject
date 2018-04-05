package pkutepv.dao.employer_dao;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pkutepv.dao.user_dao.User;
import pkutepv.dao.user_dao.UserServices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Transactional(isolation = Isolation.READ_COMMITTED)
public class EmployeeDaoImpl extends NamedParameterJdbcDaoSupport implements EmployeeDao {
    UserServices userServices;
    DepartamentDao departamentDao;

    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }

    public void setDepartamentDao(DepartamentDao departamentDao) {
        this.departamentDao = departamentDao;
    }

    @Override
    @Transactional(readOnly = true)
    public void addEmployee(User user, Departament departament) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT user_id, departament_id INTO pharmacydatabase.employee ")
                .append("VALUES( ")
                .append(departament.getDepartamentId() + ", ")
                .append(user.getUserId() + " )");
        getJdbcTemplate().update(sql.toString());

    }

    @Override
    @Transactional(readOnly = true)
    public void delEmployee(User user) {

    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployee() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.employee ");
        return getNamedParameterJdbcTemplate().query(sql.toString(), new EmployeeRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployeeById(int employeeId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.employee WHERE employee_id = ").append(employeeId);
        return getJdbcTemplate().queryForObject(sql.toString(), new EmployeeRowMapper());
    }

    private class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            int userId = rs.getInt("user_id");
            int departamentId = rs.getInt("departament_id");

            return new Employee(rs.getInt("locality_id"), userServices.getUserById(userId),
                    departamentDao.getDepartamentById(departamentId));

        }
    }
}
