package co.twibble.service;

import co.twibble.dao.UserDAO;
import co.twibble.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

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

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        return buildUserForAuthentication(userDAO.getUserByUserName(userName));
    }

    // Converts co.twibble.User user to
    // org.springframework.security.core.userdetails.User
    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user) {

        boolean enabled=false;
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        switch (user.getUserStatus()) {
            case ACTIVE:
                enabled = true;
                break;
            case DISABLED:
                enabled = false;
                break;
            default:
                enabled = false;
                break;
        }

        authorities.add(new SimpleGrantedAuthority(user.getUserType().toString()));

        org.springframework.security.core.userdetails.User springSecurityUser = new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                enabled,
                true,
                true,
                true,
                authorities);

        return springSecurityUser;
    }


}
