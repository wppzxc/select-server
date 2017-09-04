package my.select.exception;

/**
 * Created by wpp on 2017/5/16.
 */
public class RepeatChooseException extends RuntimeException {
    public RepeatChooseException(String message) {
        super(message);
    }

    public RepeatChooseException(String message, Throwable cause) {
        super(message, cause);
    }
}
