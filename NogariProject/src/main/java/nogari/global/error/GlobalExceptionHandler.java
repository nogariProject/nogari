package nogari.global.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * [Exception]
     * Controller의 Arguement 영역에서
     * @Valid 유효성 검증을 통과하지 못 하였을 경우 처리
     *
     * @param ex MethodArgumentNotValidException
     * @return ResponseEntity<ErrorResponse>
     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
//        final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND, ex.getBindingResult());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    /**
     * [Exception]
     * 처리하지 못한 모든 예외들에 대해서 처리
     *
     * @param ex Exception
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> normalExceptionHandler(Exception ex) {

        log.debug("GlobalExceptionHandler.normalExceptionHandler{}", ex.getClass());
        log.debug("GlobalExceptionHandler.normalExceptionHandler error Message{}", ex.getMessage());

        final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}