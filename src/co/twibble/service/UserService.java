package co.twibble.service;

import co.twibble.model.User;

/**
 * The UserService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-20
 */
public interface UserService {
    public void addUser(User user);
    public User getUserByUserName(String userName);
}
