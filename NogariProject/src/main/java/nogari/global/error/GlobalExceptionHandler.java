package nogari.global.error;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.log.service.ErrorLogService;
import org.springframework.dao.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ErrorLogService service;

    /**
     * [Exception] 비즈니스 예외
     * @param exception
     * @param webRequest
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException exception, WebRequest webRequest) {
        // log.error("[{}.handleBusinessException]", this.getClass().getSimpleName(), exception);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.BUSINESS_EXCEPTION_ERROR);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * [Exception] 접근이 허용되지 않을 떄
     * @param exception
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException exception) {
        // log.error("[{}.handleAccessDeniedException]", this.getClass().getSimpleName(), exception);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.NO_PERMISSION);
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    /**
     * [Exception] controller에서 전달한 값이 유효성을 통과하지 못했을 때
     * @param exception
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(Exception exception) {
        log.error("[{}.handleMethodArgumentNotValidExceptionHandler]", this.getClass().getSimpleName(), exception);
        BindingResult bindingResult = getBindingResult(exception);
        ErrorCode errorCode = ErrorCode.NOT_VALID_ERROR;
        final ErrorResponse response = ErrorResponse.of(errorCode, bindingResult);
        return new ResponseEntity<>(response, errorCode.getHttpStatus());
    }

    private BindingResult getBindingResult(Exception exception) {
        if (exception instanceof MethodArgumentNotValidException) {
            return ((MethodArgumentNotValidException) exception).getBindingResult();
        } else if (exception instanceof BindException) {
            return ((BindException) exception).getBindingResult();
        }
        return null;
    }

    /**
     * [Exception] Controller에서 @RequstParam 에서 필수값 검증
     * @param exception
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException exception) {
        // log.error("[{}.handleMissingServletRequestParameterException] {}", this.getClass().getSimpleName(), exception);
        ErrorCode errorCode = ErrorCode.NOT_VALID_ERROR;
        String field = exception.getParameterName();
        List<ErrorResponse.CustomFieldError> resultList = Collections.singletonList(
                ErrorResponse.CustomFieldError.builder().field(field).message(errorCode.getMessage()).build()
        );
        final ErrorResponse response = ErrorResponse.of(errorCode, resultList);
        return new ResponseEntity<>(response, errorCode.getHttpStatus());
    }

    /**
     * [Exception] @RequstParam에서 패턴 검증을 통과하지 못 하였을 경우 발생
     *
     * @param exception ConstraintViolationException
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException exception) {
        log.error("[{}.handleConstraintViolationException] {}", this.getClass().getSimpleName(), exception);

        ErrorCode errorCode = ErrorCode.NOT_VALID_ERROR;

        List<ErrorResponse.CustomFieldError> resultList = new ArrayList<>();
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        for (ConstraintViolation<?> violation : constraintViolations) {
            Path propertyPath = violation.getPropertyPath();
            String field = getCurrentLeafNodeName(propertyPath);
            String value = violation.getInvalidValue().toString();
            String message = violation.getMessage().toString();

            ErrorResponse.CustomFieldError errorField = ErrorResponse.CustomFieldError.builder().field(field).value(value).message(message).build();
            resultList.add(errorField);
        }

        final ErrorResponse response = ErrorResponse.of(errorCode, resultList);
        return new ResponseEntity<>(response, errorCode.getHttpStatus());
    }

    private static String getCurrentLeafNodeName(Path propertyPath) {
        return StreamSupport.stream(propertyPath.spliterator(), false)
                .reduce((past, current) -> current)
                .map(Path.Node::getName)
                .orElse(null);
    }

    /**
     * [Exception] 잘못된 서버 요청일 경우 발생한 경우
     *
     * @param exception HttpClientErrorException
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    protected ResponseEntity<ErrorResponse> handleBadRequestException(HttpClientErrorException exception, WebRequest webRequest) {
//        log.error("[{}.handleBadRequestException] {}", this.getClass().getSimpleName(), webRequest.getDescription(true), exception);
        ErrorCode errorCode = ErrorCode.BAD_REQUEST;
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, errorCode.getHttpStatus());
    }


    /**
     * [Exception]지원하지 않은 HTTP method 호출 할 경우 발생
     *
     * @param exception HttpRequestMethodNotSupportedException
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
//        log.error("[{}.handleHttpRequestMethodNotSupportedException]", this.getClass().getSimpleName(), exception);
        ErrorCode errorCode = ErrorCode.BAD_REQUEST;
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, errorCode.getHttpStatus());
    }

    /**
     * 자격증명 없음
     * @param exception
     * @return
     */
    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<ErrorResponse> handleBadCredentialsException(BadCredentialsException exception) {
        log.error("[{}.handleBadCredentialsException]", this.getClass().getSimpleName(), exception);
        ErrorCode errorCode = ErrorCode.INVALID_USER_DATA;
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, errorCode.getHttpStatus());
    }

    /**
     * 토큰만료
     * @param exception
     * @return
     */
    @ExceptionHandler(ExpiredJwtException.class)
    protected ResponseEntity<ErrorResponse> handleExpiredJwtException(ExpiredJwtException exception) {
        log.error("[{}.handleExpiredJwtException]", this.getClass().getSimpleName(), exception);
        ErrorCode errorCode = ErrorCode.TOKEN_EXPIRED;
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, errorCode.getHttpStatus());
    }



    /**
     * [Exception] DB 에러관련 오류들
     *
     * @param exception DataAccessException
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(DataAccessException.class)
    protected ResponseEntity<ErrorResponse> handleDataAccessException(DataAccessException exception, HttpServletRequest request) {
        log.error("[{}.handleDataAccessException]", this.getClass().getSimpleName(), exception);
        ErrorCode errorCode = determineErrorCode(exception);
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, errorCode.getHttpStatus());
    }
    private ErrorCode determineErrorCode(DataAccessException exception) {
        if (exception instanceof BadSqlGrammarException) {
            return ErrorCode.DB_BAD_SQL_GRAMMAR;
        } else if (exception instanceof InvalidResultSetAccessException) {
            return ErrorCode.DB_INVALID_RESULT_SET_ACCESS;
        } else if (exception instanceof DuplicateKeyException) {
            return ErrorCode.DB_DUPLICATE_KEY;
        } else if (exception instanceof DataIntegrityViolationException) {
            return ErrorCode.DB_DATA_INTEGRITY_VIOLATION;
        } else if (exception instanceof DataAccessResourceFailureException) {
            return ErrorCode.DB_DATA_ACCESS_RESOURCE_FAILURE;
        } else if (exception instanceof CannotAcquireLockException) {
            return ErrorCode.DB_CANNOT_ACQUIRE_LOCK_EXCEPTION;
        } else if (exception instanceof DeadlockLoserDataAccessException) {
            return ErrorCode.DB_DEADLOCK_LOSER_DATA_ACCESS;
        } else if (exception instanceof CannotSerializeTransactionException) {
            return ErrorCode.DB_CANNOT_SERIALIZE_TRANSACTION;
        } else {
            return ErrorCode.DB_EXCEPTION;
        }
    }

    /**
     * [Exception] 위에서 처리되지 않은 모든 에러
     * 해당 에러는 디비에 저장
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception exception, WebRequest webRequest) {
        log.error("[{}.handleException]", this.getClass().getSimpleName(), exception);
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        final ErrorResponse response = ErrorResponse.of(errorCode);
        try {
            service.createErrorLog(exception, webRequest);
        } catch (Exception innerException) {
            log.error("[{}.handleException-createErrorLog]", this.getClass().getSimpleName(), innerException);
        } finally {
            return new ResponseEntity<>(response, errorCode.getHttpStatus());
        }
    }

}
