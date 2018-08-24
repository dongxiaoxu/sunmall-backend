package site.dongxiaoxu.sunmall.framework.session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dongxu on 2018/8/23.
 */
public class SessionManage {

    private volatile static SessionManage sessionManage;

    private Map<String, UserSession> sessions = new ConcurrentHashMap<>(1024);


    private Map<String, String> userNameSessionMapper = new ConcurrentHashMap<>(1024);


    private SessionManage() {}

    public static SessionManage getSessionManage() {
        if (sessionManage == null) {
            synchronized (SessionManage.class) {
                if (sessionManage == null) {
                    sessionManage = new SessionManage();
                }
            }
        }
        return sessionManage;
    }

    public void createSession(UserSession session) {
        String oldSessionId;
        oldSessionId = this.userNameSessionMapper.remove(session.getUserName());
        if (oldSessionId != null) {
            this.sessions.remove(oldSessionId);
        }
        this.sessions.put(session.getSessionId(), session);
        this.userNameSessionMapper.put(session.getUserName(), session.getSessionId());
    }

    public void deleteSession(String userName) {
        String sessionId;
        sessionId = this.userNameSessionMapper.remove(userName);
        if (sessionId != null) {
            this.sessions.remove(sessionId);
        }
    }

    public UserSession getUserSessionByUserName(String userName) {
        String sessionId;
        sessionId = this.userNameSessionMapper.get(userName);
        return sessionId == null ? null : this.sessions.get(sessionId);
    }

    public UserSession getUserSessionBySessionId(String sessionId) {
        return this.sessions.get(sessionId);
    }
}
