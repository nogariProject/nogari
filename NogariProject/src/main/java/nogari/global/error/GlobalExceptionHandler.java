package nogari.global.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.log.domain.dto.ErrorLogDTO;
import nogari.system.log.service.ErrorLogService;
import org.springframework.dao.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.sql.SQLException;
import java.util.Set;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {


    private final ErrorLogService errorLogService;

    /**
     * [Exception] Controller에서 @Valid 유효성 검증을 통과하지 못 하였을 경우 발생
     * 따로 저장은 안함. 사용자에게 알려줄분
     * @param ex MethodArgumentNotValidException
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        log.info("{}", this.getClass().getSimpleName());
        BindingResult bindingResult = ex.getBindingResult();
        final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND, bindingResult);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * [Exception] Controller에서 RequstParam에서 패턴 검증을 통과하지 못 하였을 경우 발생
     * 따로 저장은 안함. 사용자에게 알려줄분
     * @param ex ConstraintViolationException
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ErrorResponse> constraintViolationExceptionHandler(ConstraintViolationException ex) {

        String  msg = "";

        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        for (ConstraintViolation<?> violation : constraintViolations) {
            Path propertyPath = violation.getPropertyPath();
            String currentLeafNodeName = getCurrentLeafNodeName(propertyPath);
            msg  += currentLeafNodeName;
            msg  += "§";
            msg  += violation.getMessage().toString();
            msg  += "||";

        }

        final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND,"데이터를 확인해주세요.",msg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private static String getCurrentLeafNodeName(Path propertyPath) {
        Path.Node currentLeafNode = null;
        for (Path.Node node : propertyPath) {
            currentLeafNode = node;
        }
        return (currentLeafNode != null) ? currentLeafNode.getName() : null;
    }


    /**
     * Controller에서 RequstParam에서 필수값 검증
     * [Exception] MissingServletRequestParameterException
     * 따로 저장은 안함. 사용자에게 알려줄분
     * @param ex Exception
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<ErrorResponse> MissingServletRequestParameterExceptionHandler(MissingServletRequestParameterException ex, HttpServletRequest request) {

        String msg = "";
        String errMsg  = "필수값입니다.확인해주세요";
        String filedCode = ex.getParameterName();
        msg  += filedCode;
        msg  += "§";
        msg  += errMsg;
        msg  += "||";


        final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND,"오류가 발생하였습니다 확인해주세요.",msg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }





    /**
     * [Exception] 위에서 처리하지 못한 모든 예외에서 발생
     *
     * @param ex Exception
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> normalExceptionHandler(Exception ex , HttpServletRequest request) {
        log.info("{}", this.getClass().getSimpleName());

        String url = request.getRequestURI();
        String method = request.getMethod();

        String errCode = "-1";
        String errMsg  = ex.getMessage();
        String rsltMsg = "";
        String errType = "";


        rsltMsg  += errCode+"";
        rsltMsg  += "§";
        rsltMsg  += errMsg;
        rsltMsg  += "||";

        String tmpErrCode = errCode+"";
        ErrorLogDTO paramDTO = ErrorLogDTO.builder().memberId("C18009").errMsg(errMsg).errCd(tmpErrCode).reqPath(url).serPath(method).errType(errType).build();

        try {
            errorLogService.errLogSave(paramDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND,"오류가 발생하였습니다 확인해주세요.",rsltMsg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * DB 에러관련 오류들
     * @param ex DataAccessException
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(DataAccessException.class)
    protected ResponseEntity<ErrorResponse> DataAccessExceptionHandler(DataAccessException ex, HttpServletRequest request) {

        int errCode    = 0;
        String errMsg  = "";
        String rsltMsg = "";
        String errType = "";

        // log.info("[DataAccessException >> getErrMsg] getMessage :: {}", ex.get);
        log.info( "[DataAccessException >> getErrMsg] getMessage :: {}", ex.getMessage() );
        String str = getClass().getSimpleName();
        if( ex instanceof BadSqlGrammarException ) {
            SQLException se = ( (BadSqlGrammarException) ex ).getSQLException();

            errCode = se.getErrorCode();
            errMsg = se.getMessage();
            errType = "BadSqlGrammarException";

        } else if( ex instanceof InvalidResultSetAccessException ) {
            SQLException se = ( (InvalidResultSetAccessException) ex ).getSQLException();
            errCode = se.getErrorCode();
            errMsg = se.getMessage();
            errType = "InvalidResultSetAccessException";
        } else if( ex instanceof DuplicateKeyException ) {
            // 고유성 제한 위반과 같은 데이터 삽입 또는 업데이트시 무결성 위반
            errCode = -1;
            errMsg  = "중복된 데이터가 존재합니다."; // ;
            errType = "DuplicateKeyException";
        } else if( ex instanceof DataIntegrityViolationException) {
            // 고유성 제한 위반과 같은 데이터 삽입 또는 업데이트시 무결성 위반
            // "등록된 데이터가 컬럼의 속성과 다릅니다. (길이, 속성, 필수입력항목 등..)";
            errCode = -1;
            //errMsg  = getMessage("dataIntegrityViolationException"); // "등록된 데이터가 컬럼의 속성과 다릅니다. (길이, 속성, 필수입력항목 등..)";
            errMsg = "중복된 데이터가 존재합니다."; // ;
            errType = "DataIntegrityViolationException";
        } else if( ex instanceof DataAccessResourceFailureException) {
            // 데이터 액세스 리소스가 완전히 실패했습니다 (예 : 데이터베이스에 연결할 수 없음)
            errCode = -1;
            errMsg = "데이터베이스 연결오류"; // "";
            errType = "DataAccessResourceFailureException";
        } else if( ex instanceof CannotAcquireLockException) {

        } else if( ex instanceof DeadlockLoserDataAccessException ) {
            // 교착 상태로 인해 현재 작업이 실패했습니다.
            errCode = -1;
            errMsg = "교착 상태로 인해 현재 작업이 실패했습니다."; // "교착 상태로 인한 현재 작업 실패";
            errType = "DeadlockLoserDataAccessException";
        } else if( ex instanceof CannotSerializeTransactionException ) {
            errCode = -1;
            errMsg = "직렬화 모드에서 트랜잭션을 완료 할 수 없음";
            errType = "CannotSerializeTransactionException";
        } else {
            errCode = -1;
            errMsg = ex.getMessage();
        }


        rsltMsg  += errCode+"";
        rsltMsg  += "§";
        rsltMsg  += errMsg;
        rsltMsg  += "||";

        String url = request.getRequestURI();
        String method = request.getMethod();

        String tmpErrCode = errCode+"";
        ErrorLogDTO paramDTO = ErrorLogDTO.builder().memberId("C18009").errMsg(errMsg).errCd(tmpErrCode).reqPath(url).serPath(method).errType(errType).build();

        try {
            errorLogService.errLogSave(paramDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND,"오류가 발생하였습니다 확인해주세요.",rsltMsg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * [Exception] NullPointerException
     * @param ex Exception
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<ErrorResponse> NullPointerExceptionHandler(NullPointerException ex, HttpServletRequest request) {

        String msg = "";
        String errMsg  = ex.getMessage();
        String errCode = "-1";
        String errType = "NullPointerException";

        msg  += errCode;
        msg  += "§";
        msg  += errMsg;
        msg  += "||";

        String url = request.getRequestURI();
        String method = request.getMethod();

        String tmpErrCode = errCode+"";
        ErrorLogDTO paramDTO = ErrorLogDTO.builder().memberId("C18009").errMsg(errMsg).errCd(tmpErrCode).reqPath(url).serPath(method).errType(errType).build();

        try {
            errorLogService.errLogSave(paramDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND,"오류가 발생하였습니다 확인해주세요.",msg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * [Exception] SqlException에러
     *
     * @param ex Exception
     * @return ResponseEntity<ErrorResponse>

    @ExceptionHandler(SQLException.class)
    protected ResponseEntity<ErrorResponse> SQLExceptionHandler(SQLException ex) {
        String msg = "";
        String errMsg  = ex.getCause() == null ? ex.getMessage(): ex.getCause().getMessage(); //sql오류메세지
        String errCode = ex.getErrorCode()+""; //에러코드Db

        msg  += errCode;
        msg  += "§";
        msg  += errMsg;
        msg  += "||";

        final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND,"오류가 발생하였습니다 확인해주세요.",msg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
     */
    /**
     * [Exception] BadSqlGrammarException
     *
     * @param ex Exception
     * @return ResponseEntity<ErrorResponse>

    @ExceptionHandler(BadSqlGrammarException.class)
    protected ResponseEntity<ErrorResponse> BadSqlGrammarExceptionHandler(BadSqlGrammarException ex) {

        SQLException se = ex.getSQLException();

        String msg = "";
        String errMsg  = se.getMessage();
        String errCode = se.getErrorCode()+"";

        msg  += errCode;
        msg  += "§";
        msg  += errMsg;
        msg  += "||";

        final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND,"오류가 발생하였습니다 확인해주세요.",msg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
     */

    /**
     * [Exception] UncategorizedSQLException
     *
     * @param ex Exception
     * @return ResponseEntity<ErrorResponse>

    @ExceptionHandler(UncategorizedSQLException.class)
    protected ResponseEntity<ErrorResponse> UncategorizedSQLExceptionHandler(UncategorizedSQLException ex) {

        SQLException se = ex.getSQLException();

        String msg = "";
        String errMsg  = se.getMessage();
        String errCode = se.getErrorCode()+"";

        msg  += errCode;
        msg  += "§";
        msg  += errMsg;
        msg  += "||";

        final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND,"오류가 발생하였습니다 확인해주세요.",msg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
     */
    /**
     * 키충돌처리
     * [Exception] DuplicateKeyException
     * @param ex Exception
     * @return ResponseEntity<ErrorResponse>

    @ExceptionHandler(DuplicateKeyException.class)
    protected ResponseEntity<ErrorResponse> DuplicateKeyExceptionHandler(DuplicateKeyException ex) {

        //
        String msg = "";
        String errMsg  = ex.getMessage();
        String errCode = "-1";

        msg  += errCode;
        msg  += "§";
        msg  += errMsg;
        msg  += "||";

        final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND,"오류가 발생하였습니다 확인해주세요.",msg);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
     */
}