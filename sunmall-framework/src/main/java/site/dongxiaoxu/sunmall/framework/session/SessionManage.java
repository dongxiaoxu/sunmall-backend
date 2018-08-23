package site.dongxiaoxu.sunmall.framework.session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dongxu on 2018/8/23.
 */
public class SessionManage {

    private volatile static SessionManage sessionManage;

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

    private Map<String, UserSession> sessions = new ConcurrentHashMap<String, UserSession>(1024);


    public void createSession(UserSession session) {
        sessions.put(session.getSessionId(), session);
    }

    public boolean deleteSession(UserSession session) {
        this.sessions.remove(session.getSessionId());
        return true;
    }
}
