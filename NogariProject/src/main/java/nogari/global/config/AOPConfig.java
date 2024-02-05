package nogari.global.config;

import lombok.extern.slf4j.Slf4j;
import nogari.global.error.ErrorContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Slf4j
@Component
public class AOPConfig {
    @AfterThrowing(pointcut = "execution(* nogari..controller.*Controller.*(..))", throwing = "exception")
    public void logExceptionAtController(JoinPoint joinPoint, Exception exception) {
        StringBuilder target = new StringBuilder()
                .append(joinPoint.getTarget().getClass().getName())
                .append(".")
                .append(joinPoint.getSignature().getName());
        ErrorContext.setErrorContext(target.toString());
    }
}
