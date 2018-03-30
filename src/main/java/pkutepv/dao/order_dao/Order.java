package pkutepv.dao.order_dao;

import pkutepv.dao.medicine_dao.Medicine;
import pkutepv.entity.Model;

import javax.persistence.*;

public class Order extends Model {

    private final Medicine medicine;

    private final OrderInfo orderInfo;

    private final int count;

    public Order(Long id, Medicine medicine, OrderInfo orderInfo, int count) {
        super(id);
        this.medicine = medicine;
        this.orderInfo = orderInfo;
        this.count = count;
    }


    public Medicine getMedicine() {
        return medicine;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public int getCount() {
        return count;
    }
}
