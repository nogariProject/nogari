package nogari.global.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.log.service.ErrorLogService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ErrorLogService service;

    /**
     * 비즈니스 예외 (런타임 상속)
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException exception, WebRequest webRequest) {
//        log.error("[{}.handleBusinessException]", this.getClass().getSimpleName(), exception);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.BUSINESS_EXCEPTION_ERROR);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생
     *
     * @param exception AccessDeniedException
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException exception) {
//        log.error("[{}.handleAccessDeniedException]", this.getClass().getSimpleName(), exception);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.NO_PERMISSION);
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    /**
     * controller @Valid 유효성을 통과하지 못했을 때
     * 로그는 db에 기록되지 않음.
     *
     * @param exception MethodArgumentNotValidException
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception, WebRequest webRequest) {
//        log.error("[{}.handleMethodArgumentNotValidExceptionHandler]", this.getClass().getSimpleName(), exception);
        BindingResult bindingResult = exception.getBindingResult();
        final ErrorResponse response = ErrorResponse.of(ErrorCode.NOT_VALID_ERROR, bindingResult);
        return new ResponseEntity<>(response, HttpStatus.OK);
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
        final ErrorResponse response = ErrorResponse.of(ErrorCode.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * SQL Exception (비즈니스 상 유효한 DB에러가 아닌 것들)
     *
     * @param exception DataAccessException
     * @return
     */
    @ExceptionHandler(DataAccessException.class)
    protected ResponseEntity<ErrorResponse> handleDataAccessException(DataAccessException exception) {
//        log.error("[{}.handleDataAccessException]", this.getClass().getSimpleName(), exception);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생
     *
     * @param exception HttpRequestMethodNotSupportedException
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
//        log.error("[{}.handleHttpRequestMethodNotSupportedException]", this.getClass().getSimpleName(), exception);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    /**
     * 처리되지 않은 모든 에러
     * 해당 에러는 디비에 저장
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception exception, WebRequest webRequest) {
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
        try {
            service.createErrorLog(exception, webRequest);
        } catch (Exception innerException) {
            log.error("[{}.handleException-createErrorLog]", this.getClass().getSimpleName(), innerException);
        } finally {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

}