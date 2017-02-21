package co.twibble.service;

import co.twibble.dao.UserDAO;
import co.twibble.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The UserServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-20
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {

        this.userDAO = userDAO;
    }

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public User getUserByUserName(String userName) {
        return userDAO.getUserByUserName(userName);
    }

}
