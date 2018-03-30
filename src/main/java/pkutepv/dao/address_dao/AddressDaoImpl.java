package pkutepv.dao.address_dao;

import org.hibernate.SessionFactory;

public class AddressDaoImpl {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
