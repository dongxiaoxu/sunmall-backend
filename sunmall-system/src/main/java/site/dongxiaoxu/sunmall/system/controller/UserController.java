package site.dongxiaoxu.sunmall.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.dongxiaoxu.sunmall.system.model.User;
import site.dongxiaoxu.sunmall.system.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * Created by dongxu on 2018/8/22.
 */
@Controller
@RequestMapping("/main/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/getUser.mvc")
    @ResponseBody
    public Map<String, Object> getUser(String userName) {
        return this.userService.getUser(userName);
    }

    @RequestMapping("/getAllUsers.mvc")
    @ResponseBody
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
}
