package co.twibble.dao;

import co.twibble.model.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The AbstractDAO class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-20
 */
public abstract class AbstractDAO {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void persist(Configuration configuration) {
        getSession().persist(configuration);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }

}
