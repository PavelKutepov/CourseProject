package pkutepv.dao.order_dao;


import pkutepv.dao.address_dao.Address;
import pkutepv.dao.employer_dao.Employee;
import pkutepv.entity.Model;
import pkutepv.dao.user_dao.UserInfo;

import javax.persistence.*;
import java.util.Date;

public class OrderInfo extends Model {

    private final UserInfo userInfo;

    private final Employee employee;

    private final Address address;

    private final Date date;

    public OrderInfo(Long id, UserInfo userInfo, Employee employee, Address address, Date date) {
        super(id);
        this.userInfo = userInfo;
        this.employee = employee;
        this.address = address;
        this.date = date;
    }



    public UserInfo getUserInfo() {
        return userInfo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Address getAddress() {
        return address;
    }

    public Date getDate() {
        return date;
    }
}
