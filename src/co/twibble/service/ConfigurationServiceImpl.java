package co.twibble.service;

import co.twibble.dao.ConfigurationDAO;
import co.twibble.model.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The ConfigurationServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-20
 */
@Service("configurationService")
@Transactional
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    private ConfigurationDAO configurationDAO;

    public void setConfigurationDAO(ConfigurationDAO configurationDAO) {

        this.configurationDAO = configurationDAO;
    }

    public void addConfiguration(Configuration configuration) {
        configurationDAO.addConfiguation(configuration);

    }
    public Configuration getConfiguration() {
        return configurationDAO.getConfiguration();
    }

}
