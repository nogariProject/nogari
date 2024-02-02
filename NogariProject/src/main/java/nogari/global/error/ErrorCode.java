package nogari.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    // 인증 && 인가 A
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "A-001", "토큰이 만료되었습니다."),
    NOT_VALID_TOKEN(HttpStatus.UNAUTHORIZED, "A-002", "해당 토큰은 유효한 토큰이 아닙니다."),
    NOT_EXISTS_AUTHORIZATION(HttpStatus.UNAUTHORIZED, "A-003", "Authorization Header가 빈 값입니다."),
    NOT_VALID_BEARER_GRANT_TYPE(HttpStatus.UNAUTHORIZED, "A-004", "인증 타입이 Bearer 타입이 아닙니다."),
    REFRESH_TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, "A-005", "해당 refresh token은 존재하지 않습니다."),
    REFRESH_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "A-006", "해당 refresh token은 만료됐습니다."),
    NOT_ACCESS_TOKEN_TYPE(HttpStatus.UNAUTHORIZED, "A-007", "해당 토큰은 ACCESS TOKEN이 아닙니다."),
    NO_PERMISSION(HttpStatus.UNAUTHORIZED, "A-008", "권한 없음"),
    FORBIDDEN_ROLE(HttpStatus.FORBIDDEN, "A-009", "해당 Role이 아닙니다."),
    UNAUTHORIZED_MEMBER(HttpStatus.UNAUTHORIZED, "A-010", "회원 정보가 일치하지 않습니다."),

    // 멤버관련 M
    NOT_EXISTS_USER_ID(HttpStatus.NOT_FOUND, "M-001", "존재하지 않는 유저 아이디입니다."),
    NOT_EXISTS_USER_NICKNAME(HttpStatus.NOT_FOUND, "M-002", "존재하지 않는 유저 닉네임입니다."),
    NOT_EXISTS_USER_EMAIL(HttpStatus.NOT_FOUND, "M-003", "존재하지 않는 유저 이메일입니다."),
    ALREADY_REGISTERED_USER_ID(HttpStatus.BAD_REQUEST, "M-004", "이미 존재하는 유저 아이디입니다."),
    NOT_EXISTS_USER_PASSWORD(HttpStatus.NOT_FOUND, "M-005", "존재하지 않는 유저 비밀번호입니다."),
    INVALID_USER_DATA(HttpStatus.BAD_REQUEST, "M-006", "잘못된 유저 정보입니다."),
    INVALID_ADMIN(HttpStatus.BAD_REQUEST, "M-007", "관리자가 아닙니다."),


    // 일반 입력값 관련 C
    BUSINESS_EXCEPTION_ERROR(HttpStatus.NOT_FOUND, "C-001", "요청이 잘못되었습니다."), //분류하기 힘든 사용자의 비즈니스 에러 통칭
    NOT_VALID_ERROR(HttpStatus.NOT_FOUND, "C-002", "전달받은 값이 유효하지 않습니다."), // @RequestBody 및 @RequestParam, @PathVariable 값이 유효하지 않음
    DB_CANNOT_SAVE(HttpStatus.INTERNAL_SERVER_ERROR, "C-003", "데이터가 저장이 이뤄지지 않습니다."), // @RequestBody 및 @RequestParam, @PathVariable 값이 유효하지 않음


    // 서버 관련 G
    NOT_FOUND(HttpStatus.NOT_FOUND, "G-001", "찾을 수 없는 페이지 요청입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "G-002", "알 수 없는 내부오류가 발생했습니다. 관리자에게 문의하세요."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "G-003", "잘못된 요청입니다")
;

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }
}