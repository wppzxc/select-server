package my.select.exception;

/**
 * Created by wpp on 2017/5/16.
 */
public class NoCountException extends RuntimeException {
    public NoCountException(String message) {
        super(message);
    }

    public NoCountException(String message, Throwable cause) {
        super(message, cause);
    }
}
