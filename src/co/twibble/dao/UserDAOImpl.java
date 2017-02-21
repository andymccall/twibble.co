package co.twibble.dao;

import co.twibble.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * The ConfigurationDAOImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-20
 */
@Repository("userDAO")
public class UserDAOImpl extends AbstractDAO implements UserDAO {

    public void addUser(User user) {
        persist(user);
    }

    public User getUserByUserName(String userName) {

        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("userName",userName));
        return (User) criteria.uniqueResult();

    }

}
