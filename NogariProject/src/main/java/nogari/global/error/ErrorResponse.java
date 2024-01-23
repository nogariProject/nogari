package nogari.global.error;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Global Exception Handler에서 발생한 에러에 대한 응답 처리를 관리
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {

    private int status;                 // 에러 상태 코드
    private String resultMsg;           // 에러 메시지
    private List<FieldError> errors;    // 상세 에러 메시지


    /**
     * ErrorResponse 생성자-1
     *
     * @param status HttpStatus
     */

    protected ErrorResponse(final HttpStatus status) {
        this.status = status.value();
    }

    protected ErrorResponse(final HttpStatus status, String resultMsg) {
        this.status = status.value();
        this.resultMsg = resultMsg;
    }

    protected ErrorResponse(final HttpStatus status, BindingResult bindingResult) {
        this.status = status.value();
        this.errors = FieldError.of(bindingResult);
    }

    /**
     * Global Exception 전송 타입-1
     *
     * @param status HttpStatus
     * @param bindingResult BindingResult
     * @return ErrorResponse
     */

    public static ErrorResponse of(final HttpStatus status, final BindingResult bindingResult) {
        return new ErrorResponse(status, bindingResult);
    }

    /**
     * Global Exception 전송 타입-2
     *
     * @param status HttpStatus
     * @return ErrorResponse
     */
    public static ErrorResponse of(final HttpStatus status) {
        return new ErrorResponse(status);
    }


    /**
     * 에러를 e.getBindingResult() 형태로 전달 받는 경우 해당 내용을 상세 내용으로 변경하는 기능을 수행한다.
     */
    @Getter
    public static class FieldError {
        private final String field;
        private final String value;
        private final String message;

//        public static List<FieldError> of(final String field, final String value, final String reason) {
//            List<FieldError> fieldErrors = new ArrayList<>();
//            fieldErrors.add(new FieldError(field, value, reason));
//            return fieldErrors;
//        }

        private static List<FieldError> of(final @NotNull BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors;
            fieldErrors = bindingResult.getFieldErrors();

            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }

        @Builder
        FieldError(String field, String value, String message) {
            this.field = field;
            this.value = value;
            this.message = message;
        }
    }
}
