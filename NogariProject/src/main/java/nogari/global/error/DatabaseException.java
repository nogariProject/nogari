package nogari.global.error;

import lombok.Getter;

import java.io.IOException;
import java.sql.SQLException;

@Getter
public class DatabaseException extends IOException {
    private ErrorCode errorCode;
    private String message;

    public DatabaseException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
