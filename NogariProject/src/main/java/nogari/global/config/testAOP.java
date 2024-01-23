package nogari.global.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class testAOP {

    @Pointcut("execution(* nogari.sample.service.*.get*(..))")
    private void myPointcut() {}

    @Before("myPublicPointcut()")
    public void beforeService() {
        log.info("TestAop@@@@@@@@@@@@@@@@@@@@");
    }


    @Pointcut("execution(public * nogari.sample.service.*.get*(..))") //접근제안한 pubulic 하면서 get으로 시작하는 메소드만
    private void myPublicPointcut() {}

   /*
    @Pointcut("@within(org.springframework.web.bind.annotation.RestControllerAdvice)") //@ControllerAdvice붙은 클래스에 적용함
    private void myExceptionLogPointcut() {

    }
    */


    @Before(" @within(org.springframework.web.bind.annotation.RestControllerAdvice) ")
    public void beforeLogExceptionService(JoinPoint joinpoint) {
        Object[] arr= joinpoint.getArgs();
        Exception testExcep = (Exception)arr[0];
        log.info("TestAop.java에서 로그남긴다1@@@@@@@@@@@@@@@@@@@@ {}",arr.length);
        log.info("TestAop.java에서 로그남긴다2@@@@@@@@@@@@@@@@@@@@ {}",testExcep.getMessage());

    }


}
