package co.twibble.service;

import co.twibble.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * The UserService interface
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-02-20
 */
public interface UserService extends UserDetailsService {

    // UserService Methods
    public void addUser(User user);
    public User getUserByUserName(String userName);

    // UserDetailService Contract Methods
    public UserDetails loadUserByUsername(String userName);

}
