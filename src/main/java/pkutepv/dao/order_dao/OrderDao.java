package pkutepv.dao.order_dao;

import pkutepv.dao.medicine_dao.Medicine;

import java.util.List;

public interface OrderDao {
    List<Order> getOrderList(Medicine medicine, OrderInfo orderInfo, int count);
}
