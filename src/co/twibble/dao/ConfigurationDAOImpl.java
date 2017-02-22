package co.twibble.dao;

import co.twibble.model.Configuration;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
/**
 * The ConfigurationDAOImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-20
 */
@Repository("configurationDAO")
public class ConfigurationDAOImpl extends AbstractDAO implements ConfigurationDAO {

    public void addConfiguation(Configuration configuration) {
        persist(configuration);
    }

    public void updateConfiguration(Configuration configuration) {
        update(configuration);
    }

    public Configuration getConfiguration(int blogId) {
        Criteria criteria = getSession().createCriteria(Configuration.class);
        criteria.add(Restrictions.eq("blogId",blogId));
        return (Configuration) criteria.uniqueResult();

    }

}