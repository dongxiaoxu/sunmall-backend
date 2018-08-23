package site.dongxiaoxu.sunmall.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.dongxiaoxu.sunmall.system.model.User;
import site.dongxiaoxu.sunmall.system.service.UserService;

import java.util.List;

/**
 * Created by dongxu on 2018/8/22.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/getUser.mvc")
    public User getUser(String userName) {
        return this.userService.getUser(userName);
    }

    @RequestMapping("/getAllUsers.mvc")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
}
