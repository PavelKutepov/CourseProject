package pkutepv.dao.order_dao;

import pkutepv.dao.address_dao.Address;
import pkutepv.dao.employer_dao.Employee;
import pkutepv.dao.user_dao.UserInfo;

import java.util.Date;
import java.util.List;

public interface OrderInfoDao {
    List<OrderInfo> getAllOrderInfo();

    OrderInfo getOrderInfoById(int orderInfo);
    void addOrderInfo(UserInfo userInfo, Employee employee, Address address, Date date);
}
