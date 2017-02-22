package co.twibble.service;

import co.twibble.model.Configuration;

/**
 * The ConfigurationService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-20
 */
public interface ConfigurationService {
    public void addConfiguration(Configuration configuration);
    public void updateConfiguration(Configuration configuration);
    public Configuration getConfiguration(int blogId);
}
