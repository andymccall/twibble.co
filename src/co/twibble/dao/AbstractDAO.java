package co.twibble.dao;

import co.twibble.model.Configuration;
import co.twibble.model.Post;
import co.twibble.model.User;
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

    public void persist(Configuration entity) {
        getSession().persist(entity);
    }
    public void update(Configuration entity) { getSession().update(entity);}

    public void persist(User entity) {
        getSession().persist(entity);
    }
    public void update(User entity) { getSession().update(entity);}

    public void persist(Post entity) { getSession().persist(entity);}
    public void update(Post entity) { getSession().update(entity);}

    public void delete(Object entity) {
        getSession().delete(entity);
    }

}
