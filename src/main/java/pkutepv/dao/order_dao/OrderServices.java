package pkutepv.dao.order_dao;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderServices {
    List<Order> getOrderList();

    Order getOrderById(int orderId);
}
