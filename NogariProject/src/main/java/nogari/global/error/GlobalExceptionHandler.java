package nogari.global.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import nogari.global.error.DTO.ErrorLogDTO;
import nogari.global.error.service.ErrorLogService;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	ErrorLogService errorLogService;
	
	/*  사용자의 요청은 error가 났기 때문에 HttpStatus.NOT_FOUND 등 에러정보를 ErrorResponse 객체(response)에 담고,
	 *  ResponseEntity 객체에 에러정보와 현재 에러핸들링(?)의 결과(송수신상태)는 정상작동이므로 HttpStatus.OK상태를 RETURN
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ErrorResponse> normalExceptionHandler(MethodArgumentNotValidException ex) {
		
		// 오류로그 저장
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		BindingResult bindingResult = ex.getBindingResult();
		
		String customErrorMessage = "아이디를 입력하세요";
		
		//ErrorLogDTO edto = new ErrorLogDTO("", request.getRequestURL().toString(), "" , bindingResult.getFieldError().getDefaultMessage(), "0000", customErrorMessage, bindingResult.getRawFieldValue("user").toString());
		
		//errorLogService.saveError(edto);
		
		// of객체에서 인스턴스를 생성해서 반환해 주므로 final선언이 가능(변조방지)
		final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND, customErrorMessage, bindingResult);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
}
