package pkutepv.dao.employer_dao;

import org.hibernate.SessionFactory;

public class EmployeeDaoImpl {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
