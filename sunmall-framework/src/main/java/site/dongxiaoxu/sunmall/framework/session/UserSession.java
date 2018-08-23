package site.dongxiaoxu.sunmall.framework.session;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by dongxu on 2018/8/23.
 */
public class UserSession {

    private String userName;

    private String userId;

    public UserSession(HttpSession session) {
        if (session == null) {
            throw new IllegalArgumentException("session not allow null!");
        }
        this.sessionId = session.getId();
        this.session = session;
    }

    private String sessionId;

    private HttpSession session;

    public HttpSession getSession() {
        return this.session;
    }

    public String getSessionId() {
        return this.sessionId;
    }



}
