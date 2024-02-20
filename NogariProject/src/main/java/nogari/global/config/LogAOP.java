package nogari.global.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.system.log.domain.entity.ErrLog;
import nogari.system.log.service.ErrLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class LogAOP {
    @Pointcut("execution(* nogari.*.*..*.*(..))")
    private void AllMethods() {}

    @Before("AllMethods()")
    public void beforeParameterLog(JoinPoint joinPoint) {
        // 메서드 정보 받아오기
        Method method = getMethod(joinPoint);
        log.debug("======= method name = {} =======", method.getName());

        // 파라미터 받아오기
        Object[] args = joinPoint.getArgs();
        if (args.length <= 0) log.debug("no parameter");
        for (Object arg : args) {
            log.debug("parameter type = {}", arg.getClass().getSimpleName());
            log.debug("parameter value = {}", arg);
        }
    }


    // Poincut에 의해 필터링된 경로로 들어오는 경우 메서드 리턴 후에 적용
    @AfterReturning(value = "AllMethods()", returning = "returnObj")
    public void afterReturnLog(JoinPoint joinPoint, Object returnObj) {
        // 메서드 정보 받아오기
        Method method = getMethod(joinPoint);
        log.debug("======= method name = {} =======", method.getName());
        log.debug("return type = {}", (null!=returnObj)?returnObj.getClass().getSimpleName():null);
        log.debug("return value = {}", returnObj);

    }

    // JoinPoint로 메서드 정보 가져오기
    private Method getMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }
}
