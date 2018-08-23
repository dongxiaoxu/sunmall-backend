package site.dongxiaoxu.sunmall.framework.exception;

/**
 * Created by dongxu on 2018/8/22.
 */
public class BaseDaoException extends RuntimeException {
    public BaseDaoException() {
        super();
    }

    public BaseDaoException(String message) {
        super(message);
    }

    public BaseDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseDaoException(Throwable cause) {
        super(cause);
    }

    protected BaseDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
