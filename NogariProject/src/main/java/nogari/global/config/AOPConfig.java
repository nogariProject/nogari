package nogari.global.config;

import lombok.extern.slf4j.Slf4j;
import nogari.global.util.Util;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Slf4j
@Component
public class AOPConfig {
    private static String buildUrlInfo(RequestMapping annotation) {
        StringBuilder urlBuilder = new StringBuilder();

        // @RequestMapping의 value를 가져와서 URL에 추가
        for (String value : annotation.value()) {
            urlBuilder.append(value);
        }

        // @RequestMapping의 method 정보를 이용하여 HTTP method 지정
        RequestMethod[] methods = annotation.method();
        if (methods.length > 0) {
            urlBuilder.append(" (").append(methods[0]).append(")");
        }

        return urlBuilder.toString();
    }

    private static String buildUrlInfo(GetMapping annotation) {
        // @GetMapping의 value를 가져와서 URL에 추가
        StringBuilder urlBuilder = new StringBuilder();
        for (String value : annotation.value()) {
            urlBuilder.append(value);
        }

        // @GetMapping의 method 정보를 이용하여 HTTP method 지정
        RequestMethod[] methods = {RequestMethod.GET}; // @GetMapping은 기본적으로 GET 메소드만 허용
        urlBuilder.append(" (").append(methods[0]).append(")");

        return urlBuilder.toString();
    }

    @AfterThrowing(pointcut = "execution(* nogari..controller.*Controller.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String requestURI = request.getRequestURI();
//        log.info("uri={}", requestURI);
//
//        // 메서드 정보 추출
//        String methodName = joinPoint.getSignature().getName();
//        String className = joinPoint.getTarget().getClass().getName();
//
//        // Lombok를 사용한 SLF4J를 통한 예외 정보 로깅
//        log.error("**Exception in method {}.{}", className, methodName);
//        log.error("**Exception ={}", exception.toString());

    }

    /**
     * 포인트컷 : 에러를 핸들링하는 ControllerAdvice 전
     * 어드바이스 : 로그를 남기고, 에러 db에 저장
     *
     * @param joinPoint
     */
    @AfterReturning("@within(org.springframework.web.bind.annotation.RestControllerAdvice)")
    public void beforeErrorHandleAOP(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Throwable exception = (Throwable) args[0];
        String message = exception.getMessage();
        log.error("err={}-{}", exception.getClass().getName(), message);

        String callClass = Util.extractInfoFromException(message, Util.MatcherResult.CLASS_NAME);
        String callMethod = Util.extractInfoFromException(message, Util.MatcherResult.METHOD_NAME);
        log.info("[{}] exception place={}   {}", this.getClass().getSimpleName(), callClass, callMethod);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestURI = request.getRequestURI();
        log.info("uri={}", requestURI);
    }


}
