package site.dongxiaoxu.sunmall.system.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import site.dongxiaoxu.sunmall.system.dao.UserDao;
import site.dongxiaoxu.sunmall.system.model.User;

import java.util.List;

/**
 * Created by dongxu on 2018/8/22.
 */
@Service("userService")
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public User getUser(String userName) {
        List<User> users;
        logger.info("****************************getUser***********************");
        users = this.userDao.findByQuery("from User where userName = :userName")
                .setString("userName", userName).list();
        return users.isEmpty() ? null : users.get(0);
    }

    public List<User> getAllUsers() {
        return this.userDao.findByQuery("from User where delFlag = '0'").list();
    }
}
