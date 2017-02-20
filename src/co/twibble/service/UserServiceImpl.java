package co.twibble.service;

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
}
