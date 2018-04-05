package pkutepv.dao.order_dao;

import java.util.List;

public class OrderServicesImpl implements OrderServices {
    private OrderDao orderDao;

    @Override
    public List<Order> getOrderList() {
        return orderDao.getOrderList();
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderDao.getOrderById(orderId);
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
