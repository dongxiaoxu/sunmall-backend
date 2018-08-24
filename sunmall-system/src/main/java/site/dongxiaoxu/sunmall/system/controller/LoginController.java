package site.dongxiaoxu.sunmall.system.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.dongxiaoxu.sunmall.framework.session.SessionManage;
import site.dongxiaoxu.sunmall.framework.session.UserSession;
import site.dongxiaoxu.sunmall.framework.utils.RedisUtil;
import site.dongxiaoxu.sunmall.system.model.User;
import site.dongxiaoxu.sunmall.system.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.util.Map;

/**
 * Created by dongxu on 2018/8/23.
 */
@RestController
public class LoginController {

    @Autowired
    @Qualifier("redisUtil")
    private RedisUtil redisUtil;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/login.mvc")
    public Map<String, Object> login(HttpServletRequest request, String userName, String password) {
        Map<String, Object> rltMap;
        rltMap = new HashedMap();
        String result;
        if (userName == null || password == null) {
            result = "failure";
        } else {
            User user;
            user = this.userService.getUser(userName);
            String md5Password;
            md5Password = DigestUtils.md5Hex(password);
            if (user == null || !md5Password.equals(user.getPassword())) {
                result = "failure";
            } else {
                result = "success";
                HttpSession session = request.getSession(true);
                UserSession userSession;
                userSession = new UserSession(session.getId(), user.getUserName());

                SessionManage.getSessionManage().createSession(userSession);
                rltMap.put("userInfo", user);
            }
        }
        rltMap.put("result", result);
        return rltMap;
    }

    @RequestMapping("/logout.mvc")
    public void logout(String userName) {
        redisUtil.set("userName", userName);
        Object username = redisUtil.get("userName");

        SessionManage.getSessionManage().deleteSession(userName);
    }
}
