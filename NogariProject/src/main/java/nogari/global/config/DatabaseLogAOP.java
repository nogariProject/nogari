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
@AllArgsConstructor
public class DatabaseLogAOP {

    private final ErrLogService errLogService;
    @Pointcut("@within(org.springframework.web.bind.annotation.RestControllerAdvice)")
    private void PointCutRestControllerAdvice() {}
    @Before("PointCutRestControllerAdvice()")
    public void beforeRestControllerAdvice(JoinPoint joinPoint){
        // 메서드 정보 받아오기
        Method method = getMethod(joinPoint);
        log.debug("======= method name = {} =======", method.getName());
        Object obj = joinPoint.getArgs()[0];

        if (obj instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) obj;
            ErrLog errLog = ErrLog.builder().errMsg(ex.getMessage()).build();
            log.debug("ae390ei092qurq903jqr!@@@@@@@@@22{}",errLog.toString());
            errLogService.createError(errLog);
        }
    }
    // JoinPoint로 메서드 정보 가져오기
    private Method getMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }

}
