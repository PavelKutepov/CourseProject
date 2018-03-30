package pkutepv.dao.order_dao;

import org.hibernate.SessionFactory;

public class OrderDaoImpl {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
