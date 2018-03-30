package pkutepv.dao.medicine_dao;

import org.hibernate.SessionFactory;

public class MedicineDaoImpl {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
