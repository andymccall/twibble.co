package co.twibble.dao;

import co.twibble.model.User;

/**
 * The UserDAO class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-21
 */
public interface UserDAO {
    public void addUser(User user);
    public User getUserByUserName(String userName);
}
