package site.dongxiaoxu.sunmall.framework.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ajax跨域访问统一添加响应头Access-Control-Allow-Origin和Access-Control-Allow-Method
 * Created by dongxu on 2018/8/22.
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri;
        uri = request.getRequestURI();
        if (uri != null && uri.endsWith("/login.mvc")) {
            return true;
        }
        HttpSession session;
        session = request.getSession(false);
        return session != null;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
