package pkutepv.dao.order_dao;

import org.springframework.stereotype.Service;
import pkutepv.dao.address_dao.Address;
import pkutepv.dao.employer_dao.Employee;
import pkutepv.dao.medicine_dao.Medicine;
import pkutepv.dao.user_dao.UserInfo;

import java.util.Date;
import java.util.List;

@Service
public interface OrderService {
    List<Order> getOrderList();

    Order getOrderById(int orderId);
    OrderInfo addOrderInfo(UserInfo userInfo, Employee employee, Address address, Date date);
    Order addOrder(Medicine medicine, OrderInfo orderInfo, int count);
    OrderInfo getOrderInfoById(int orderInfoId);
    List<OrderInfo> getAllOrderInfo();
}
