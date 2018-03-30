package pkutepv.dao.order_dao;


import pkutepv.dao.address_dao.Address;
import pkutepv.dao.employer_dao.Employee;
import pkutepv.entity.Model;
import pkutepv.dao.user_dao.UserInfo;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "order_info")
public class OrderInfo extends Model {
    @ManyToOne
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(name = "date")
    @Temporal(value=TemporalType.DATE)
    private Date date;

    public OrderInfo(Long id, UserInfo userInfo, Employee employee, Address address, Date date) {
        super(id);
        this.userInfo = userInfo;
        this.employee = employee;
        this.address = address;
        this.date = date;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setDate(Date date) {
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
