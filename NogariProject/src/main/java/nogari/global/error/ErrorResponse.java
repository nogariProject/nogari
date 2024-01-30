
package nogari.global.error;

import java.util.List;

import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
	
	private int    status;
	private String message;
//	private List<FieldError> errors;			// 커스터마이징 사용X
	private List<CustomFieldError> errors;		// 커스터마이징 사용 시
	
	
	// ErrorResponse 생성자
	@Builder
	protected ErrorResponse(HttpStatus httpStatus, String message, BindingResult bindingResult) {
		this.status  = httpStatus.value();
		this.message = message;
//		this.errors  = bindingResult == null ? null : bindingResult.getFieldErrors();	// 커스터마이징 사용X
		this.errors  = CustomFieldError.of(bindingResult);	// 커스터마이징 사용 시
	}
	
	// ErrorResponse 전송타입1
	public static ErrorResponse of(HttpStatus httpStatus) {
		return ErrorResponse.builder().httpStatus(httpStatus).build();
	}
	
	// ErrorResponse 전송타입2
	public static ErrorResponse of(HttpStatus httpStatus, String message) {
		return ErrorResponse.builder()
					.httpStatus(httpStatus)
					.message(message).build();
	}
	
	// ErrorResponse 전송타입3
	public static ErrorResponse of(HttpStatus httpStatus, String message, BindingResult bindingResult) {
		return ErrorResponse.builder()
					.httpStatus(httpStatus)
					.message(message)
					.bindingResult(bindingResult).build();
	}
	
	

	// 커스터마이징 FieldError
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class CustomFieldError {
		private String field;
		private String value;
		private String reason;
		
		// CustomFieldError 생성자
		@Builder
		protected CustomFieldError(String field, String value, String reason) {
			this.field = field;
			this.value = value;
			this.reason = reason;
		}
		
		// of함수 - 인스턴스를 생성해서 return
		private static List<CustomFieldError> of(final @NotNull BindingResult bindingResult) {
			final List<org.springframework.validation.FieldError> errorList = bindingResult.getFieldErrors();
			
			// List<FieldError> -> List<CustomFieldError> 형변환
			return errorList.stream().map(s -> new CustomFieldError(
											  s.getField()
											, s.getRejectedValue() == null ? "" : s.getRejectedValue().toString()
											, s.getDefaultMessage()))
									 .collect(Collectors.toList());
		}
		
	}

	
}
