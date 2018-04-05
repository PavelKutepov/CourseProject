package pkutepv.dao.order_dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pkutepv.dao.address_dao.AddressService;
import pkutepv.dao.address_dao.Address;
import pkutepv.dao.employer_dao.Employee;
import pkutepv.dao.employer_dao.EmployeeService;
import pkutepv.dao.user_dao.UserInfo;
import pkutepv.dao.user_dao.UserServices;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Transactional(isolation = Isolation.READ_COMMITTED)
public class OrderInfoDaoImpl extends NamedParameterJdbcDaoSupport implements OrderInfoDao {

    UserServices userServices;
    EmployeeService employeeService;
    AddressService addressService;


    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderInfo> getAllOrderInfo() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.order_info ");
        return getNamedParameterJdbcTemplate().query(sql.toString(), new OrderInfoRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public OrderInfo getOrderInfoById(int orderInfoId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.order_info WHERE order_info_id = ").append(orderInfoId);
        return getJdbcTemplate().queryForObject(sql.toString(), new OrderInfoRowMapper());
    }

    @Override
    public void addOrderInfo(UserInfo userInfo, Employee employee, Address address, Date date) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO pharmacydatabase.order_info ")
                .append("VALUES( ")
                .append(userInfo.getUserInfoId() + ", ")
                .append(employee.getEmployeeId() + ", ")
                .append(address.getAddressId() + ", ")
                .append(date + " )");
        getJdbcTemplate().execute(sql.toString());
    }

    private class OrderInfoRowMapper implements RowMapper<OrderInfo> {


        @Override
        public OrderInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            int userInfoId = rs.getInt("user_info_id");
            int employeeId = rs.getInt("employee_id");
            int addressId = rs.getInt("address_id");
            UserInfo userInfo = userServices.getUserInfoById(userInfoId);
            Employee employee = employeeService.getEmployeeById(employeeId);
            Address address = addressService.getAddressForId(addressId);
            return new OrderInfo(rs.getInt("order_info_id"), userInfo, employee, address, rs.getDate("date"));

        }
    }
}
