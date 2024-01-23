package nogari.global.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
public class testAOP {

    @Pointcut("execution(* nogari.sample.service.*.get*(..))")
    private void myPointcut() {}

    @Before("myPointcut()")
    public void beforeService() {
        log.info("@@@@@@@@@@@@@@@@@@@@");
    }
}
