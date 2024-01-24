package nogari;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAOP {
	// @within : 클래스의 어노테이션
	// @annotation : 메소드의 어노테이션
	@Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
	public void contollerPointCut() {}
	
	@Before("contollerPointCut()")
	public void beforeController() {
		System.out.println("@@before Controller");
	}
	
	@After("bean(*Controller)")
	public void afterController() {
		System.out.println("@@after  Controller");
	}
	
	@Around("@within(org.springframework.web.bind.annotation.RestController)")
	public Object aroundController(ProceedingJoinPoint joinPoint) throws Throwable {
		
		try {
			System.out.println("@@around Controller start");
			return joinPoint.proceed();
		}finally {
			System.out.println("@@around Controller finish");
		}
		
	}
}
