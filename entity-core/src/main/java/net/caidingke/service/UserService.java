package net.caidingke.service;

import io.ebean.EbeanServer;
import net.caidingke.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bowen.
 */
@Service
public class UserService {
    @Autowired
    EbeanServer ebeanServer;

    @Transactional(rollbackFor = Exception.class)
    public User findByUsername(String username) {
        User user = User.find.where().username.eq(username).findUnique();
        return user;
    }
}
