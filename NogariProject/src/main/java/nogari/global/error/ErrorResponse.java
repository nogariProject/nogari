package nogari.global.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Global Exception Handler에서 발생한 에러에 대한 응답 처리를 관리
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    private String message;                 // 에러 메시지
    private String code;                    // 에러코드
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CustomFieldError> errors;  // 필드 에러 메시지

    /**
     * 빌더 패턴이 적용된 ErrorResponse 생성자
     *
     * @param message
     * @param bindingResult
     */
    @Builder
    protected ErrorResponse(final String code, final String message, BindingResult bindingResult, final List<ErrorResponse.CustomFieldError> fieldErrors) {
        this.message = message;
        this.code = code;
        this.errors = List.of();

        if (bindingResult != null) {
            this.errors = CustomFieldError.of(bindingResult);
        } else if (fieldErrors != null) {
            this.errors = fieldErrors;
        }
    }

    /**
     * ErrorResponse 인스턴스 반환
     *
     * @param errorCode
     * @return
     */
    public static ErrorResponse of(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .code(errorCode.getErrorCode())
                .message(errorCode.getMessage())
                .build();
    }


    /**
     * ErrorResponse 인스턴스 반환
     *
     * @param errorCode
     * @param bindingResult
     * @return
     */
    public static ErrorResponse of(ErrorCode errorCode, BindingResult bindingResult) {
        return ErrorResponse.builder()
                .code(errorCode.getErrorCode())
                .message(errorCode.getMessage())
                .bindingResult(bindingResult)
                .build();
    }

    /**
     * ErrorResponse 인스턴스 반환
     *
     * @param errorCode
     * @param FieldErrorList
     * @return
     */
    public static ErrorResponse of(ErrorCode errorCode, List<ErrorResponse.CustomFieldError> FieldErrorList) {
        return ErrorResponse.builder()
                .code(errorCode.getErrorCode())
                .message(errorCode.getMessage())
                .fieldErrors(FieldErrorList)
                .build();
    }

    /**
     * 에러를 e.getBindingResult() 형태로 전달 받는 경우 해당 내용을 상세 내용으로 변경하는 기능을 수행한다.
     */
    @Getter
    public static class CustomFieldError {
        private final String field;
        private final String value;
        private final String message;

        @Builder
        CustomFieldError(String field, String value, String message) {
            this.field = field;
            this.value = value;
            this.message = message;
        }

        private static List<CustomFieldError> of(final @NotNull BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors;
            fieldErrors = bindingResult.getFieldErrors();

            return fieldErrors.stream()
                    .map(error -> new CustomFieldError(
                            error.getField(),
                            Objects.toString(error.getRejectedValue(), ""),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }
}
