package co.twibble.dao;

import co.twibble.model.Configuration;

/**
 * The ConfigurationDAO class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-20
 */
public interface ConfigurationDAO {
    public void addConfiguation(Configuration configuration);
    public void updateConfiguration(Configuration configuration);
    public Configuration getConfiguration(int blogId);
}
