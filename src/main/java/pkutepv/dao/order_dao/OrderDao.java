package pkutepv.dao.order_dao;

import pkutepv.dao.medicine_dao.Medicine;

import java.util.List;

public interface OrderDao {
    List<Order> getOrderList();

    List<Order> getOrderListByOrderInfoId(int orderInfoId);

    Order getOrderById(int orderId);

    Order addOrder(Medicine medicine, OrderInfo orderInfo, int count);
}
