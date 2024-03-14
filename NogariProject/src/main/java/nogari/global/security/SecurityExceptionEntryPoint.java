package nogari.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import nogari.global.error.ErrorCode;
import nogari.global.error.ErrorResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <pre>
 * 필터 예외는 @RestControllerAdvice를 타지 않기 때문에
 * 별도의 처리가 필요함
 * </pre>
 */
@Component
@Slf4j
public class SecurityExceptionEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.error("[{}.commence]", this.getClass().getSimpleName(), authException);
        ErrorCode errorCode = ErrorCode.NOT_VALID_TOKEN;

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(errorCode.getHttpStatus().value());  // 401 Status code

        final ErrorResponse errorResponse = ErrorResponse.of(errorCode);
        objectMapper.writeValue(response.getOutputStream(), errorResponse);
    }
}
