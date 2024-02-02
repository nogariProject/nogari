package nogari.global.error;

import lombok.Getter;

@Getter
public class DatabaseException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;

    public DatabaseException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
