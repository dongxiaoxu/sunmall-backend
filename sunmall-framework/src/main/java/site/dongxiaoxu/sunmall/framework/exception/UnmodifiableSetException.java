package site.dongxiaoxu.sunmall.framework.exception;

/**
 * Created by dongxu on 2018/8/24.
 */
public class UnmodifiableSetException extends RuntimeException {
    public UnmodifiableSetException() {
    }

    public UnmodifiableSetException(String message) {
        super(message);
    }

    public UnmodifiableSetException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnmodifiableSetException(Throwable cause) {
        super(cause);
    }

    public UnmodifiableSetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
