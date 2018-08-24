package site.dongxiaoxu.sunmall.framework.session;

import site.dongxiaoxu.sunmall.framework.exception.UnmodifiableSetException;

import java.util.Map;

/**
 * Created by dongxu on 2018/8/23.
 */
public class UserSession {

    public UserSession(String sessionId, String userName) {
        if (sessionId == null) {
            throw new IllegalArgumentException("sessionId not allow null!");
        } else if (userName == null) {
            throw new IllegalArgumentException("userName not allow null!");
        }
        this.sessionId = sessionId;
        this.userName = userName;
    }

    private final String sessionId;

    private final String userName;

    private Map<String, Object> userParams;

    public String getSessionId() {
        return sessionId;
    }


    public String getUserName() {
        return userName;
    }

    public Map<String, Object> getUserParams() {
        return userParams;
    }


    public void setUserParams(Map<String, Object> userParams) {
        if (userParams == null) {
            throw new IllegalArgumentException("userParam is null!");
        } else if (this.userParams != null){
            throw new UnmodifiableSetException("userParams alreay set!");
        } else {
            this.userParams = userParams;
        }
    }
}
