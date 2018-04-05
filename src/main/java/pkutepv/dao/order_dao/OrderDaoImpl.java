package pkutepv.dao.order_dao;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pkutepv.dao.medicine_dao.Medicine;
import pkutepv.dao.medicine_dao.MedicineServices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Transactional(isolation = Isolation.READ_COMMITTED)
public class OrderDaoImpl extends NamedParameterJdbcDaoSupport implements OrderDao {

    private MedicineServices medicineServices;
    private OrderInfoDao orderInfoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrderList() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.order ");
        return getNamedParameterJdbcTemplate().query(sql.toString(), new OrderRowMapper());
    }

    @Override
    @Transactional(readOnly = true)
    public Order getOrderById(int orderId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pharmacydatabase.order WHERE order_id = ").append(orderId);
        return getJdbcTemplate().queryForObject(sql.toString(), new OrderRowMapper());
    }

    @Override
    public void addOrder(int orderId, Medicine medicine, OrderInfo orderInfo, int count) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO pharmacydatabase.order ")
                .append("VALUES( ")
                .append(orderInfo.getOrderInfoId() + ", ")
                .append(medicine.medicine_id + ", ")
                .append(orderInfo.getOrderInfoId() + ", ")
                .append(count + " )");
        getJdbcTemplate().execute(sql.toString());
    }

    private class OrderRowMapper implements RowMapper<Order> {

        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            int medicineId = rs.getInt("medicine_id");
            int orderInfoId = rs.getInt("order_info_id");
            OrderInfo orderInfo = orderInfoDao.getOrderInfoById(orderInfoId);
            Medicine medicine = medicineServices.getMedecineById(medicineId);
            return new Order(rs.getInt("order_id"), medicine, orderInfo, rs.getInt("count"));

        }
    }
}
