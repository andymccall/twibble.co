package co.twibble.dao;

import co.twibble.model.Configuration;
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

    }
    public Configuration getConfiguration() {

        return new Configuration();
    }

}