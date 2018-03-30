package pkutepv.dao.order_dao;

import pkutepv.dao.medicine_dao.Medicine;
import pkutepv.entity.Model;

import javax.persistence.*;
@Entity
@Table(name = "order")
public class Order extends Model {
    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;
    @ManyToOne
    @JoinColumn(name = "order_info_id")
    private OrderInfo orderInfo;
    @Column(name = "count")
    private int count;

    public Order(Long id, Medicine medicine, OrderInfo orderInfo, int count) {
        super(id);
        this.medicine = medicine;
        this.orderInfo = orderInfo;
        this.count = count;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public void setCount(int count) {
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
