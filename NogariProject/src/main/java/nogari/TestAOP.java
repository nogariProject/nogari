package nogari;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAOP {
	@Before("@within(org.springframework.web.bind.annotation.RestController)")
	public void beforeController() {
		System.out.println("@@before Controller");
	}
	
	@After("@within(org.springframework.web.bind.annotation.RestController)")
	public void afterController() {
		System.out.println("@@after Controller");
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
